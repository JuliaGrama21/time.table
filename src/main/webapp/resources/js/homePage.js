$('document').ready(function () {

    $('#goToTeacher').click(function () {
        parent.location = '/listOfTeachers';
    });

    $('#goToGroup').click(function () {
        parent.location = '/listOfGroups'
    });

    $('#goToRoom').click(function () {
        parent.location = '/listOfRooms';
    });
});