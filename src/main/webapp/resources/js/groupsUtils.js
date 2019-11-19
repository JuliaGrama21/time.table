$('document').ready(function () {

    $('.deleteGroup').each(function () {
        var btn = $(this);
        btn.click(function () {
            if (confirm("Are you sure you want to delete this group?")) {
                $.ajax({
                    url: '/deleteGroup',
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
        console.log('hello')

        var z = document.forms["addGroup"]["number"].value;
        if(/\D/.test(z))
        {
            alert("Please only enter numeric characters for group! (Allowed input:0-9)");
            return false;
        }
    }
});