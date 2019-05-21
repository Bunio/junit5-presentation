package com.onemoreline.calculator.discovery;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;


/**
 * Running JUnit tests without IDE / Maven support.
 */
public class TestDiscovery {

    public static void main(String... args) {

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("com.onemoreline.calculator"))
                .build();

        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        System.out.println("\n\nTEST SUMMARY : ");
        System.out.println("Succceeded: " + listener.getSummary().getTestsSucceededCount());
        System.out.println("Failed: " + listener.getSummary().getTestsFailedCount());
        System.out.println("Skipped: " + listener.getSummary().getTestsSkippedCount());
        System.out.println("Aborted: " + listener.getSummary().getTestsAbortedCount());
        System.out.println("Total: " + listener.getSummary().getTestsFoundCount());

    }
}
