package org.insu.claim.harnesses;

import org.insu.claim.harnesses.stateful.KillSwitches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class SystemUnderTestHarness {
    private final KillSwitches killSwitches;

    private final ProcessBuilder processBuilder;
    private Process process;
    private Thread stdoutPumpThread;
    private Thread stderrPumpThread;

    public SystemUnderTestHarness(ProcessBuilder systemUnderTestProcBuilder) {
        killSwitches = new KillSwitches();
        this.processBuilder = systemUnderTestProcBuilder;
    }

    private void readStreamPerpetually(InputStream stream) {
        InputStreamReader stdStreamReader = new InputStreamReader(stream);
        BufferedReader stdStreamBuffer = new BufferedReader(stdStreamReader);

        try {
            while ((stdStreamBuffer.readLine()) != null) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Runnable buildStdOutPump(Process systemUnderTestProcess) {
        return () -> {
            while (!this.killSwitches.killSystemUnderTest) {
                InputStream stdOutStream = systemUnderTestProcess.getInputStream();
                readStreamPerpetually(stdOutStream);
            }
        };
    }

    private Runnable buildStdErrPump(Process systemUnderTestProcess) {
        return () -> {
            while (!this.killSwitches.killSystemUnderTest) {
                InputStream stdErrStream = systemUnderTestProcess.getErrorStream();
                readStreamPerpetually(stdErrStream);
            }
        };
    }

    public void initialize() throws IOException {
        this.process = this.processBuilder.start();
        Runnable pumpForStdout = buildStdOutPump(this.process);
        Runnable pumpForStderr = buildStdErrPump(this.process);

        stdoutPumpThread = new Thread(pumpForStdout);
        stderrPumpThread = new Thread(pumpForStderr);

        stdoutPumpThread.start();
        stderrPumpThread.start();
    }

    public void kill() {
        this.killSwitches.killSystemUnderTest = true;

        this.process.destroy();

        while (stdoutPumpThread.isAlive() || stderrPumpThread.isAlive()) {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
