package com.pavlov.soap.service;

import com.pavlov.soap.model.ServiceNotifierEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName(value = "Test WEB service_notifier")
class NotificationServiceImplTest {
    static NotificationService notificationService = new NotificationServiceImpl();
    static ServiceNotifierEntity entity;

    @BeforeEach
    void setUp() {
        entity = new ServiceNotifierEntity(1, 1, 1);
        System.out.println(entity);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName(value = "Get user by id (1)")
    void getEntity() {
        ServiceNotifierEntity entity = notificationService.getEntityById(1);
        assertNotNull(entity);

    }

    @Test
    void getString() {
    }

    @Test
    void getEntityById() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getSession() {
    }
}