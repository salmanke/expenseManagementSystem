

let showAddExpense = () => {
	$(".expense").removeClass("container custom-border mt-5 p-5 expense").addClass("container custom-border mt-5 p-5")
	$(".btn2").attr("disabled", "disabled")
	
	
}

let makeAddExpenseDisappear = () => {
	$(".expense").removeClass("container custom-border mt-5 p-5").addClass("container custom-border mt-5 p-5 expense")
	$(".btn2").attr("disabled", "")
}

let addToModal = (eid,eType) => {	
	
	
	console.log("id", eid)
	 let add  =   `<input type="hidden" name="expenseId" value="${JSON.parse(eid)}" >
                  <input type="hidden" name="expenseType" value="${eType}" >`;
	$("#list-body").html(add);
}