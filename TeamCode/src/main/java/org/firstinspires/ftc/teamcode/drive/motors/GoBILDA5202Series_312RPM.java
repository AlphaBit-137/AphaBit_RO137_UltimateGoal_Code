package org.firstinspires.ftc.teamcode.drive.motors;

import com.qualcomm.robotcore.hardware.configuration.DistributorInfo;
import com.qualcomm.robotcore.hardware.configuration.annotations.DeviceProperties;
import com.qualcomm.robotcore.hardware.configuration.annotations.ExpansionHubPIDFPositionParams;
import com.qualcomm.robotcore.hardware.configuration.annotations.ExpansionHubPIDFVelocityParams;
import com.qualcomm.robotcore.hardware.configuration.annotations.MotorType;

import org.firstinspires.ftc.robotcore.external.navigation.Rotation;

@MotorType(ticksPerRev=537.6, gearing=19.2, maxRPM=312, orientation=Rotation.CCW)
@DeviceProperties(xmlTag="goBILDA5202SeriesMotor_312RPM", name="GoBILDA 5202 series 312RPM", builtIn = true)
@DistributorInfo(distributor="goBILDA_distributor", model="goBILDA-5202-312RPM", url="https://www.gobilda.com/5202-series-yellow-jacket-planetary-gear-motor-19-2-1-ratio-312-rpm-3-3-5v-encoder/")
@ExpansionHubPIDFVelocityParams(P=2.0, I=0.5, F=11.1)
@ExpansionHubPIDFPositionParams(P=5.0)
public interface GoBILDA5202Series_312RPM {}
