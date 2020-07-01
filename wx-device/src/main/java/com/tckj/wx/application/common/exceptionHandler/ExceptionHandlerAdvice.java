package com.tckj.wx.application.common.exceptionHandler;

import com.tckj.wx.application.common.util.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResultHelper badRequestException(IllegalArgumentException exception) {
		return ResultHelper.failed2Msg(exception.getMessage());
	}

	@ExceptionHandler({GFCException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResultHelper badGFCException(GFCException exception) {
		return ResultHelper.failed2Msg(exception.getErrMsg());
	}

	@ExceptionHandler({Exception.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResultHelper badException(Exception exception) {
		return ResultHelper.failed2Msg(exception.getMessage());
	}
}
