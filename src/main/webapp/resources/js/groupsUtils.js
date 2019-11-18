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


    $('#showTimeTableForGroup').click(function () {
        parent.location = '/searchGroup';
    });

    $('#addNewGroup').click(function () {
        parent.location = '/addGroup';
    });

    $('#showAllGroups').click(function () {
        parent.location = '/listOfGroups';
    });
});