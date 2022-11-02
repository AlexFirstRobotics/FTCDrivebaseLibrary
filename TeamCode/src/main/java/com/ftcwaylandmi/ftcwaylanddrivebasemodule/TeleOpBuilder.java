package com.ftcwaylandmi.ftcwaylanddrivebasemodule;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;

import com.ftcwaylandmi.ftcwaylanddrivebasemodule.drivebases.RearDrive;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;

public class TeleOpBuilder
{

    /* Qualcomm Libraries */

    /* Called Classes */
    private FtcWaylandDrivebaseModule ftcWaylandDrivebaseModule;
    private Config config;

    private DcMotor moduleA = ftcWaylandDrivebaseModule.moduleA;
    private DcMotor moduleB = ftcWaylandDrivebaseModule.moduleB;

    private final String teleOpName = config.TeleOpName;
    private final String teleOpGroup = config.TeleOpGroup;

    public void CreateTeleOpRearDrive (
            boolean telemetryEnabled
    )
    {
        @com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = teleOpName, group = teleOpGroup)
        abstract class TeleOp extends OpMode
        {

            RearDrive rearDrive = new RearDrive();

            @Override
            public void init(){rearDrive.SetModules(

            );
            }
            @Override
            public void loop(){

                rearDrive.SetTeleOpDrive(

                );

                if (telemetryEnabled==true){
                    telemetry.addData(
                            "moduleATicks",
                            rearDrive.GetModuleAMotorTicks()
                    );
                    telemetry.addData(
                            "moduleBTicks",
                            rearDrive.GetModuleBMotorTicks()
                    );
                    telemetry.update();
                }
            }

        }
        moduleA.setMode(RUN_USING_ENCODER);
        moduleB.setMode(RUN_USING_ENCODER);
    }



}
