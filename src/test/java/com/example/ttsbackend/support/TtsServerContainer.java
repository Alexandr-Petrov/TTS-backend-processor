package com.example.ttsbackend.support;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.lifecycle.Startable;

public class TtsServerContainer implements Startable {

    private static GenericContainer<?> ttsContainer = new GenericContainer<>("synesthesiam/mozilla-tts")
            .withExposedPorts(5002)
            .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
                    new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(5002), new ExposedPort(5002)))
            ));

    @Override
    public void start() {
        ttsContainer.start();
    }

    @Override
    public void stop() {
        ttsContainer.stop();
    }
}
