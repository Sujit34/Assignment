$(() => {

  $("#add").submit(() => {
    const data = {
      fname: $("#fname").val(),
      lname: $("#lname").val(),
      food: $("#food").val(),
      arrivalTime: $("#arrivalTime").val(),
    };
    $.post({
      url: "/add",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
    })
      .done(asuccess)
      .fail(afail);
    return false;
  });


  const clear = () => $("#msg").text("");
  const asuccess = () => {
    $("#fname").val("");
    $("#lname").val("");
    $("#arivalTime").val("");
    $("#msg").text("Data added successfully");
    $("#fname").focus();
    setTimeout(clear, 3000);
  };
  const afail = () => {
    $("#msg").text("Unable to reach server");
    setTimeout(clear, 10000);
  };  
});
