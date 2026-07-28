package com.hms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Laboratory implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String labId;
    private final LabType type;
    private final List<String> operatorIds;

    public Laboratory(String labId, LabType type) {
        this.labId = labId;
        this.type = type;
        this.operatorIds = new ArrayList<>();
    }

    public String getLabId() { return labId; }
    public LabType getType() { return type; }
    public List<String> getOperatorIds() { return Collections.unmodifiableList(operatorIds); }

    public void addOperator(String operatorId) {
        if (!operatorIds.contains(operatorId)) {
            operatorIds.add(operatorId);
        }
    }
}