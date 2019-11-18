$('document').ready(function () {

    $('.deleteTeacher').each(function () {
        var btn = $(this);
        btn.click(function () {
            if (confirm("Are you sure you want to delete this teacher?")) {
                $.ajax({
                    url: '/deleteTeacher',
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
});