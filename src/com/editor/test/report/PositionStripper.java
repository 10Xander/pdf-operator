package com.editor.test.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

class PositionStripper extends PDFTextStripper {
    
    public PositionStripper() throws IOException {
		super();
	}

	List<TextPosition> positions = new ArrayList<>();
    
    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        super.writeString(string, textPositions);
        positions.addAll(textPositions);
    }
    
    public List<TextPosition> getPositions() {
        return positions;
    }
}

