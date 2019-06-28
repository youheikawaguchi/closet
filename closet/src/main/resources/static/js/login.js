$("#login_form").validate({

  rules: {
      userId: {
    	  required: true,
    	  rangelength: [4,30]
      },
      password: {
    	  required: true,
    	  rangelength: [8,100]
      },
  },

  messages: {
    userId: {
    	required: "IDを入力してください",
    	rangelength: "4文字以上30字以内で入力してください"
    },
    password: {
    	required: "パスワードを入力してください",
    	rangelength: "8文字以上100字以内で入力してください"
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
