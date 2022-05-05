
//Add expense form is hidden initially. Once add expense button is pressed, the form is visible
let showAddExpense = () => {
	$(".expense").removeClass("container custom-border mt-5 p-5 expense").addClass("container custom-border mt-5 p-5")
	$(".btn2").attr("disabled", "disabled")


}

//Add expense button should be disabled once the Add expense form is on screen
let makeAddExpenseDisappear = () => {
	$(".expense").removeClass("container custom-border mt-5 p-5").addClass("container custom-border mt-5 p-5 expense")
	$(".btn2").attr("disabled", "")
}


//For Deleting the specific expense based on Expense Id and Expense Type
let addToModal = (eid, eType) => {
	console.log("id", eid)
	let add = `<input type="hidden" name="expenseId" value="${JSON.parse(eid)}" >
                  <input type="hidden" name="expenseType" value="${eType}" >`;
	$("#list-body").html(add);
}