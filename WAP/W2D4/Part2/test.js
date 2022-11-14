describe("String Object filter function", function () {
    it("Removes banned words from the string", function () {
      let inStr = "This house is not nice!";
      let expextedOutStr = "This house is nice!";
      assert.equal(inStr.filter("not"), expextedOutStr);
    });
  });
  
  describe("Array Object bubble sort function", function () {
    it("Sort [6,4,0, 3,-2,1] through bubble sort", function () {
      let input = [6, 4, 0, 3, -2, 1];
      let expectedOutput = [-2, 0, 1, 3, 4, 6];
      assert.equal(input.bubbleSort().join(), expectedOutput.join());
    });
  });