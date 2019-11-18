$('document').ready(function () {

    $('.deleteLesson').each(function () {
        var btn = $(this);
        btn.click(function () {
            if (confirm("Are you sure you want to delete this lesson?")) {
                $.ajax({
                    url: '/deleteLesson',
                    type: 'post',
                    data: {id: btn.attr('id')},
                    success: function () {
                        console.log("success");
                        var td = btn.parent();
                        var tr = $(td).parent();
                        $(tr).remove();
                    }
                });
            }
        });
    });

    function validateForm() {
        alert("kkk");

        // var z = document.forms["addLesson-form"]["groupNumber"].value;
        // if(/\D/.test(z))
        // {
        //     alert("Please only enter numeric characters for group! (Allowed input:0-9)");
        //     //return false;
        // }
        return true;
    }
});