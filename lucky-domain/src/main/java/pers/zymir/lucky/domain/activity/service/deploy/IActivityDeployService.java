package pers.zymir.lucky.domain.activity.service.deploy;

import pers.zymir.lucky.domain.activity.model.req.ActivityDeployReq;
import pers.zymir.lucky.domain.activity.model.res.ActivityResult;

public interface IActivityDeployService {
    ActivityResult deploy(ActivityDeployReq activityDeployReq);
}
