package kodlamaio.hmrs.core.utilities.Business;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;

public class BusinessRules {
	
	public static Result run(Result... logics){
        for(Result logic:logics){
            if(!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
	}

}
