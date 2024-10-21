package com.amazon.ata.statics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrackedBoxTest {

    @Test
    public void getBoxId_fromTrackedBox_returnsBoxId() {
        //GIVEN
        TrackedBox trackedBox = new TrackedBox("A123");

        //WHEN
        String boxId = trackedBox.getBoxId();

        //THEN
        assertEquals("A123", boxId, "The boxId provided to the constructor should not be edited.");
    }

    //Since the trackingId is randomly generated we're unit testing based on the expected length of the key, which
    //should be 40 if done properly
    @Test
    public void getTrackingId_fromTrackedBox_returnsBoxIdAndUUID() {
        //GIVEN
        TrackedBox trackedBox = new TrackedBox("B123");

        //WHEN
        String trackingId = trackedBox.getTrackingId();

        //THEN
        assertTrue(trackingId.startsWith("B123"), "The trackingId should start with the boxId.");
        assertEquals(40, trackingId.length(), "A trackingId should contain the boxId " +
            "and also a UUID.");
    }

}

