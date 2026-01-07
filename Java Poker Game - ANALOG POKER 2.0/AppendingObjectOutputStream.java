// AppendingObjectOutputStream (Part of [3.3 Serializable Program])
// Made by: Henry Smith
// Created: 11/11/2025

// PURPOSE: Used to fix an issue with saving multiple students into one file. And, yes, I try just using a ArrayList, but I couldn't get the program
// to output anything other than that single array list, so I made this instead to fix the problem

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream {
    public AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {

    }
}