$(document).ready(function(){

  $('#register_form').validate({
    rules: {
        username: {
            required: true,
            minlength: 3
        },
        fio: {
            required: false
        },
        email: {
            required: true,
            email: true
        },
        address: {
            required: false
        },
        telephone: {
            required: false,
            minlength: 10,
            maxlength: 13
        },
        organization: {
            required: false,
            maxlength: 500
        },
        position: {
            required: true
        },
        unprotectedpassword: {
            minlength: 6,
            required: true
        },
        confirmpassword: {
            equalTo: "#unprotectedpassword"
        }
    },
    success: function(label) {
        label.text('OK!').addClass('valid');
    },
	submitHandler: function(form) {
	    document.getElementById("unprotectedpassword").disabled=true;
	    document.getElementById("confirmpassword").disabled=true;
        form.submit();
    }
  });

    $('#edit_form').validate({
        rules: {
            fio: {
                required: false
            },
            email: {
                required: true,
                email: true
            },
            address: {
                required: false
            },
            telephone: {
                required: false,
                minlength: 10,
                maxlength: 13
            },
            organization: {
                required: false,
                maxlength: 500
            },
            position: {
                required: true
            },
            oldpassword: {
                minlength: 6,
                required: true
            },
            unprotectedpassword: {
                minlength: 6,
                required: true
            },
            confirmpassword: {
                minlength: 6,
                equalTo: "#unprotectedpassword"
            }
        },
        success: function(label) {
            label.text('OK!').addClass('valid');
        },
        submitHandler: function(form) {
            document.getElementById("oldpassword").disabled=true;
            document.getElementById("unprotectedpassword").disabled=true;
            document.getElementById("confirmpassword").disabled=true;
            form.submit();
        }
    });

    $('#login_form').validate({
        rules: {
            username: {
                required: true,
                minlength: 3
            },
            unprotectedpassword: {
                minlength: 6,
                required: true
            }
        },
        success: function(label) {
            label.text('OK!').addClass('valid');
        },
        submitHandler: function(form) {
            document.getElementById("unprotectedpassword").disabled=true;
            form.submit();
        }
    });
  
});

