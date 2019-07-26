package api.resources.response;

public class ResponseDtoBuilder {

	public static Builder builder(){
		return new ResponseDtoBuilder.Builder();
	}

	public static class Builder {

		private ResponseDto responseDtoInstance = new ResponseDto();

		public Builder(){

		}

		public Builder withStatus(String status){
			responseDtoInstance.setStatus(status);
			return this;
		}

		public Builder withPayload(Object payload){
			responseDtoInstance.setPayload(payload);
			return this;
		}

		public Builder withMessage(String message){
			responseDtoInstance.setMessage(message);
			return this;
		}

		public ResponseDto getResponseDtoInstance() {
			return responseDtoInstance;
		}
	}
}
