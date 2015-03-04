package gui.components;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public interface Elements {
    ArrayList<JTextField> ampls = new ArrayList<>();
    ArrayList<JTextField> phases = new ArrayList<>();
    ArrayList<Integer> frekv = new ArrayList<>();

    ArrayList<JFrame> frames = new ArrayList<>();
    ArrayList<Integer> NUMBER_OF_ELEMENTS = new ArrayList<>();

}