package com.serotonin.mango.vo.report;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.serotonin.mango.vo.DataPointVO;
import com.serotonin.util.SerializationHelper;

public class ReportPointVO implements Serializable {
    private int pointId;
    private String colour;
    private boolean consolidatedChart;
    private boolean scatterChart;
    private String plotTitle;
    private String xaxisTitle;
    private String yaxisTitle;
    private int referenceLine;

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isConsolidatedChart() {
        return consolidatedChart;
    }

    public void setConsolidatedChart(boolean consolidatedChart) {
        this.consolidatedChart = consolidatedChart;
    }

    public boolean isScatterChart() {
        return scatterChart;
    }

    public void setScatterChart(boolean scatterChart) {
        this.scatterChart = scatterChart;
    }

    public String getPlotTitle() {
        return plotTitle;
    }

    public void setPlotTitle(String plotTitle) {
        this.plotTitle = plotTitle;
    }

    public String getxaxisTitle() {
        return xaxisTitle;
    }

    public void setXaxisTitle(String xaxisTitle) {
        this.xaxisTitle = xaxisTitle;
    }

    public String getyaxisTitle() {
        return yaxisTitle;
    }

    public void setYaxisTitle(String yaxisTitle) {
        this.yaxisTitle = yaxisTitle;
    }

    public int getReferenceLine() {
        return referenceLine;
    }

    public void setReferenceLine(int referenceLine) {
        this.referenceLine = referenceLine;
    }

    //
    //
    // Serialization
    //
    private static final long serialVersionUID = -1;
    private static final int version = 2;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(version);

        out.writeInt(pointId);
        SerializationHelper.writeSafeUTF(out, colour);
        out.writeBoolean(consolidatedChart);
    }

    private void readObject(ObjectInputStream in) throws IOException {
        int ver = in.readInt();

        // Switch on the version of the class so that version changes can be elegantly handled.
        if (ver == 1) {
            pointId = in.readInt();
            colour = SerializationHelper.readSafeUTF(in);
            consolidatedChart = true;
        }
        else if (ver == 2) {
            pointId = in.readInt();
            colour = SerializationHelper.readSafeUTF(in);
            consolidatedChart = in.readBoolean();
        }
    }
}