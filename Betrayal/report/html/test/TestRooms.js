var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":70,"id":9,"methods":[{"el":31,"sc":2,"sl":26},{"el":36,"sc":2,"sl":33},{"el":44,"sc":2,"sl":38},{"el":52,"sc":2,"sl":46},{"el":61,"sc":2,"sl":54},{"el":68,"sc":2,"sl":63}],"name":"TestRooms","sl":19}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_124":{"methods":[{"sl":38}],"name":"testGetRoomExitDirections","pass":true,"statements":[{"sl":40},{"sl":41},{"sl":42},{"sl":43}]},"test_137":{"methods":[{"sl":63}],"name":"testAddingARoomToANonExistingExitThrowsException","pass":false,"statements":[{"sl":65},{"sl":66},{"sl":67}]},"test_17":{"methods":[{"sl":46}],"name":"testGetRoomOrientation","pass":true,"statements":[{"sl":48},{"sl":50},{"sl":51}]},"test_28":{"methods":[{"sl":33}],"name":"testGetRoomNameReturnsProperName","pass":true,"statements":[{"sl":35}]},"test_32":{"methods":[{"sl":54}],"name":"testGetConnectingRooms","pass":true,"statements":[{"sl":56},{"sl":57},{"sl":59},{"sl":60}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [28], [], [28], [], [], [124], [], [124], [124], [124], [124], [], [], [17], [], [17], [], [17], [17], [], [], [32], [], [32], [32], [], [32], [32], [], [], [137], [], [137], [137], [137], [], [], []]
