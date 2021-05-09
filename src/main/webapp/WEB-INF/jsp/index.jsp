<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Return Of The Coder</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/parsley.js/2.9.2/parsley.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <h2 align="center">Geekseat Witch Saga: Return of The Coder!</h2>
            <form id="personForm" data-parsley-validate>
                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person1Label" class="col-sm-2 col-form-label"><b>Person A</b></label>
                </div>

                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person1Age" class="col-sm-2 col-form-label">Age of Death</label>
                    <div class="col-sm-4">
                        <input type="text" data-parsley-type="number" class="form-control" id="person1Age" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person1YearOfDeath" class="col-sm-2 col-form-label">Year of Death</label>
                    <div class="col-sm-4">
                        <input type="text" data-parsley-type="number" class="form-control" id="person1YearOfDeath" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person2Label" class="col-sm-2 col-form-label"><b>Person B</b></label>
                </div>

                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person2Age" class="col-sm-2 col-form-label">Age of Death</label>
                    <div class="col-sm-4">
                        <input type="text" data-parsley-type="number" class="form-control" id="person2Age" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-3">
                    </div>
                    <label for="person2YearOfDeath" class="col-sm-2 col-form-label">Year of Death</label>
                    <div class="col-sm-4">
                        <input type="text" data-parsley-type="number" class="form-control" id="person2YearOfDeath" required>
                    </div>
                </div>

            </form>
            <div class="form-group row">
                <div class="col-sm-3">
                </div>
                <div class="col-sm-4">
                    <button class="btn btn-primary" id="submit" onclick="submitForm()">Submit</button>
                </div>
            </div>
            <br>
            <hr>
            <br>
            <div id="result-section">
                <table class="table table-bordered">
                    <tr>
                        <th></th>
                        <th>Age of Death</th>
                        <th>Year of Death</th>
                        <th>Year of Death - Age of Death</th>
                        <th>Number of People Killed</th>
                    </tr>
                    <tr>
                        <td>Person A</td>
                        <td><span id="ageOfDeathP1" class="result"></span></td>
                        <td><span id="yearOfDeathP1" class="result"></span></td>
                        <td><span id="substractResultP1" class="result"></span></td>
                        <td><span id="numberOfPeopleKilledP1" class="result"></span></td>
                    </tr>
                    <tr>
                        <td>Person B</td>
                        <td><span id="ageOfDeathP2" class="result"></span></td>
                        <td><span id="yearOfDeathP2" class="result"></span></td>
                        <td><span id="substractResultP2" class="result"></span></td>
                        <td><span id="numberOfPeopleKilledP2" class="result"></span></td>
                    </tr>
                    <tr>
                        <td>Result</td>
                        <td colspan="4"><span id="result"></span></td>
                    </tr>
                </table>
            </div>
        </div>
        <script>
            $(function(){
                $("#result-section").hide();

            });
            function submitForm() {
                if ($("#personForm").parsley().validate()) {
                    $(".result").html("");
                    let jsonData = {};
                    jsonData = {person1 : {
                                   ageOfDeath : $("#person1Age").val(),
                                   yearOfDeath: $("#person1YearOfDeath").val()
                               },
                               person2 : {
                                   ageOfDeath : $("#person2Age").val(),
                                   yearOfDeath: $("#person2YearOfDeath").val()
                               }}

                    $.ajax({
                        url: "/theCoder/getResult",
                        data : JSON.stringify(jsonData),
                        dataType : 'json',
                        contentType : "application/json",
                        type : "POST",
                        success: function(data) {
                            if(data.result != -1) {
                                $("#ageOfDeathP1").html(data.person1.ageOfDeath);
                                $("#yearOfDeathP1").html(data.person1.yearOfDeath);
                                $("#substractResultP1").html(data.person1.yearOfDeath - data.person1.ageOfDeath);
                                $("#numberOfPeopleKilledP1").html(data.person1.numberOfPeopleKilledOnTheYear);

                                $("#ageOfDeathP2").html(data.person2.ageOfDeath);
                                $("#yearOfDeathP2").html(data.person2.yearOfDeath);
                                $("#substractResultP2").html(data.person2.yearOfDeath - data.person2.ageOfDeath);
                                $("#numberOfPeopleKilledP2").html(data.person2.numberOfPeopleKilledOnTheYear);
                            }
                            $("#result").html(data.result);
                            $("#result-section").show();
                        },
                        error: function(data) {
                            alert("Failed to process the request");
                        }
                    })
                }
            }
        </script>
    </body>
</html>