package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();

    @BeforeEach
    void setUp() {
        manager.add(".html", "app1");
        manager.add(".jpg", "app2");
        manager.add(".bmp", "app3");
        manager.add(".jar", "app2");
        manager.add(".txt", "app4");
    }

    @Test
    public void getListOfExtensions() {
        List<String> expected = new ArrayList<>(Arrays.asList(".bmp", ".html", ".jar", ".jpg", ".txt"));
        assertEquals(expected, manager.findAllExtension());
    }

    @Test
    public void getListOfExtensionsIfListEmpty() {
        List<String> expected = new ArrayList<>(Collections.emptyList());
        manager.removeAll();
        assertEquals(expected, manager.findAllExtension());
    }

    @Test
    public void getListOfApps() {
        Set<String> expected = new HashSet<>(Arrays.asList("app1", "app2", "app4", "app3"));
        assertEquals(expected, manager.findAllApp());
    }

    @Test
    public void getListOfAppsIfListEmpty() {
        Set<String> expected = new HashSet<>(Collections.emptyList());
        manager.removeAll();
        assertEquals(expected, manager.findAllApp());
    }

    @Test
    public void removesAppBinding() {
        Set<String> expected = new HashSet<>(Arrays.asList("app1", "app2", "app4"));
        manager.remove(".bmp");
        assertEquals(expected, manager.findAllApp());
    }

    @Test
    public void removesAppBindingWithUppercase() {
        Set<String> expected = new HashSet<>(Arrays.asList("app1", "app2", "app4"));
        manager.remove(".BMp");
        assertEquals(expected, manager.findAllApp());
    }

    @Test
    public void informsNameOfApp() {
        String actual = manager.getAppName(".jar");
        assertEquals("app2", actual);
    }

    @Test
    public void informsNameOfAppIfExtensionNotRegistered() {
        String actual = manager.getAppName(".mp3");
        assertNull(actual);
    }

    @Test
    public void informsNameOfAppWithUppercase() {
        String actual = manager.getAppName(".JAR");
        assertEquals("app2", actual);
    }

    @Test
    public void addNewExtensions() {
        List<String> expected = new ArrayList<>(Arrays.asList(".bmp", ".html", ".jar", ".jpg", ".mp3", ".txt"));
        manager.add(".mp3", "app5");
        assertEquals(expected, manager.findAllExtension());
    }

    @Test
    public void addNewExtensionsWithUppercase() {
        List<String> expected = new ArrayList<>(Arrays.asList(".bmp", ".html", ".jar", ".jpg", ".mp3", ".txt"));
        manager.add(".MP3", "App5");
        assertEquals(expected, manager.findAllExtension());
    }
}