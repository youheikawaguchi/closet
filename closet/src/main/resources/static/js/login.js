

jQuery.validator.addMethod("alphanum", function(value, element) {
	 return this.optional(element) || /^([a-zA-Z0-9]+)$/.test(value);
	 }, "※半角英数字で入力してください"
	);


$("#login_form").validate({

  rules: {
      userId: {
    	  required: true,
    	  rangelength: [4,30],
    	  alphanum: true
      },
      password: {
    	  required: true,
    	  rangelength: [8,100],
    	  alphanum: true
      }
  },

  messages: {
    userId: {
    	required: "※IDを入力してください",
    	rangelength: "※4文字以上30字以内で入力してください"
    },
    password: {
    	required: "※パスワードを入力してください",
    	rangelength: "※8文字以上100字以内で入力してください"
    }
  },

  errorPlacement: function(error, element){
    if(element.is("[name='userId']")){
      error.appendTo($("#UserId1_error"));
    }else if(element.is("[name='password']")){
      error.appendTo($("#Password1_error"));
    }
  }

});

