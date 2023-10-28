package tn.esprit.devops_project.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomMetricsService {

    private final MeterRegistry meterRegistry;

    @Autowired
    public CustomMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void incrementCustomCounter() {
        meterRegistry.counter("custom.counter").increment();
    }

    public void recordCustomValue(double value) {
        meterRegistry.gauge("custom.value", value);
    }
}
