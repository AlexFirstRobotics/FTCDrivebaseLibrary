package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.ftcwaylandmi.ftcwaylanddrivebasemodule.FtcWaylandDrivebaseModule;
import com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases.RearDrive;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Test
{
    FtcWaylandDrivebaseModule drivebaseModule = new FtcWaylandDrivebaseModule();

    public void Init()
    {
        drivebaseModule.DrivebaseDefines(
                30,
                90,
                20,
                20
        );

        drivebaseModule.DefineModulesRearDrive(
                "leftMotor",
                DcMotorSimple.Direction.FORWARD,
                280,
                "rightMotor",
                DcMotorSimple.Direction.REVERSE,
                280,
                DcMotor.RunMode.RUN_TO_POSITION,
                hardwareMap
        );

        drivebaseModule.DefineTeleOpDriveRearDrive(
                -gamepad1.left_stick_y,
                -gamepad1.right_stick_y,
                "TANK",
                "CUBIC",
                0
        );

        drivebaseModule.CreateTeleOpRearDriveRearDrive(true);
    }

}
