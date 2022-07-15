package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobThree.getName() instanceof String);
        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", jobThree.getName());
        assertEquals("ACME", jobThree.getEmployer().getValue());
        assertEquals("Desert", jobThree.getLocation().getValue());
        assertEquals("Quality control", jobThree.getPositionType().getValue());
        assertEquals("Persistence", jobThree.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobFour = new Job ("Paralegal", new Employer("Fragomen"), new Location("New York"), new PositionType("Legal"), new CoreCompetency("Accurate"));
        Job jobFive = new Job ("Paralegal", new Employer("Fragomen"), new Location("New York"), new PositionType("Legal"), new CoreCompetency("Accurate"));
        //System.out.println(jobFour.equals(jobFive));
        assertFalse(jobFour.equals(jobFive));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobSix = new Job();
        assertEquals('\n', jobSix.toString().charAt(0));
        assertEquals('\n', jobSix.toString().charAt(jobSix.toString().length() - 1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobSeven = new Job("Mainframe engineer", new Employer("Cigna"), new Location("remote"), new PositionType("Engineering"), new CoreCompetency("Analytical"));
//        assertEquals( '\n' + "ID: " + jobSeven.getId(), jobSeven.toString().substring(0,6));
//        assertEquals( '\n' + "Name: " + jobSeven.getName(), '\n' + jobSeven.toString().substring(7,31));
//        assertEquals( '\n' + "Employer: " + jobSeven.getEmployer(), '\n' + jobSeven.toString().substring(32,47));
//        assertEquals( '\n' + "Location: " + jobSeven.getLocation(), '\n' + jobSeven.toString().substring(48,63));
//        assertEquals( '\n' + "Position Type: " + jobSeven.getPositionType(), '\n' + jobSeven.toString().substring(64,86));
//        assertEquals( '\n' + "Core Competency: " + jobSeven.getCoreCompetency(), '\n' + jobSeven.toString().substring(87,112));
        String expected = "\nID: " + jobSeven.getId() + "\nName: Mainframe engineer\nEmployer: Cigna\nLocation: remote\nPosition Type: Engineering\nCore Competency: Analytical\n";
        assertEquals(expected, jobSeven.toString());
        //System.out.println(jobSeven.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobEight = new Job("Mainframe engineer", new Employer("Cigna"), new Location("remote"), new PositionType(""), new CoreCompetency("Analytical"));
        String expected = "\nID: " + jobEight.getId() + "\nName: Mainframe engineer\nEmployer: Cigna\nLocation: remote\nPosition Type: Data not available\nCore Competency: Analytical\n";
        assertEquals(expected, jobEight.toString());
    }
}
