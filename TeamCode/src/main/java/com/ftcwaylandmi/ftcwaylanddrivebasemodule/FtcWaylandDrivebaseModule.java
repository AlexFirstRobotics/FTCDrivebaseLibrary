package com.ftcwaylandmi.ftcwaylanddrivebasemodule;

public class FtcWaylandDrivebaseModule {

    /* DrivebaseDefines */
    private float frameWidthCM;
    private float frameLegthCM;
    private float frontWheelDiameterCM;
    private float rearWheelDiameterCM;

    public void DrivebaseDefines(
            float frameWidthCM,
            float frameLegthCM,
            float frontWheelDiameterCM,
            float rearWheelDiameterCM
    )
    {
        this.frameWidthCM = frameWidthCM;
        this.frameLegthCM = frameLegthCM;
        this.frontWheelDiameterCM = frontWheelDiameterCM;
        this.rearWheelDiameterCM = rearWheelDiameterCM;
    }

}
