const fs = require('fs')

fs.readFile('input.txt', 'utf8', function (err,data) {
  if (err) {
    return console.log(err);
  }
  let numbers = data.split('\n');

  var answer = solve(numbers);

  console.log(answer);
});

function solve(numberArray){
	var answer = -1;

	numberArray.forEach(function(element) {
		element = parseInt(element);

		var index1;
		var index2;
		for (index1 = 0; index1 < 200; index1++){

			var secondNumber = parseInt(numberArray[index1]);

			for (index2 = 0; index2 < 200; index2++){
				var thirdNumber = parseInt(numberArray[index2]);

				if (element + secondNumber + thirdNumber === 2020){
					answer = element*secondNumber*thirdNumber;
					return
				} 
			}
			
		}
	})
	return answer;
}