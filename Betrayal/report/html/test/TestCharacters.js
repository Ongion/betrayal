var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":246,"id":869,"methods":[{"el":38,"sc":2,"sl":23},{"el":54,"sc":2,"sl":40},{"el":59,"sc":2,"sl":56},{"el":64,"sc":2,"sl":61},{"el":71,"sc":2,"sl":66},{"el":78,"sc":2,"sl":73},{"el":90,"sc":2,"sl":80},{"el":105,"sc":2,"sl":92},{"el":117,"sc":2,"sl":106},{"el":132,"sc":2,"sl":119},{"el":146,"sc":2,"sl":133},{"el":162,"sc":2,"sl":147},{"el":174,"sc":2,"sl":163},{"el":192,"sc":2,"sl":175},{"el":204,"sc":2,"sl":193},{"el":243,"sc":2,"sl":206}],"name":"TestCharacters","sl":19}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":106}],"name":"testDecrementKnowledge","pass":true,"statements":[{"sl":108},{"sl":109},{"sl":110},{"sl":111},{"sl":112},{"sl":113},{"sl":114},{"sl":115},{"sl":116}]},"test_100":{"methods":[{"sl":133}],"name":"testDecrementSanity","pass":true,"statements":[{"sl":135},{"sl":136},{"sl":137},{"sl":138},{"sl":139},{"sl":140},{"sl":141},{"sl":142},{"sl":143},{"sl":144},{"sl":145}]},"test_102":{"methods":[{"sl":40}],"name":"testInitialization","pass":true,"statements":[{"sl":42},{"sl":43},{"sl":44},{"sl":45},{"sl":46},{"sl":47},{"sl":48},{"sl":49},{"sl":50},{"sl":51},{"sl":52},{"sl":53}]},"test_108":{"methods":[{"sl":73}],"name":"testGetWeight","pass":true,"statements":[{"sl":77}]},"test_139":{"methods":[{"sl":92}],"name":"testIncrementKnowledge","pass":true,"statements":[{"sl":94},{"sl":95},{"sl":96},{"sl":97},{"sl":98},{"sl":99},{"sl":100},{"sl":101},{"sl":102},{"sl":103},{"sl":104}]},"test_142":{"methods":[{"sl":66}],"name":"testGetHeight","pass":true,"statements":[{"sl":70}]},"test_145":{"methods":[{"sl":206}],"name":"testGetAttributeIndexes","pass":true,"statements":[{"sl":208},{"sl":209},{"sl":210},{"sl":211},{"sl":213},{"sl":214},{"sl":215},{"sl":216},{"sl":218},{"sl":219},{"sl":220},{"sl":221},{"sl":223},{"sl":224},{"sl":225},{"sl":226},{"sl":228},{"sl":229},{"sl":230},{"sl":231},{"sl":233},{"sl":234},{"sl":235},{"sl":236},{"sl":238},{"sl":239},{"sl":240},{"sl":241}]},"test_24":{"methods":[{"sl":163}],"name":"testDecrementMight","pass":true,"statements":[{"sl":165},{"sl":166},{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":171},{"sl":172},{"sl":173}]},"test_33":{"methods":[{"sl":56}],"name":"testGetName","pass":true,"statements":[{"sl":58}]},"test_34":{"methods":[{"sl":175}],"name":"testIncrementSpeed","pass":true,"statements":[{"sl":177},{"sl":178},{"sl":179},{"sl":180},{"sl":181},{"sl":182},{"sl":183},{"sl":184},{"sl":185},{"sl":186},{"sl":187},{"sl":188},{"sl":189},{"sl":190},{"sl":191}]},"test_36":{"methods":[{"sl":61}],"name":"testGetAge","pass":true,"statements":[{"sl":63}]},"test_46":{"methods":[{"sl":193}],"name":"testDecrementSpeed","pass":true,"statements":[{"sl":195},{"sl":196},{"sl":197},{"sl":198},{"sl":199},{"sl":200},{"sl":201},{"sl":202},{"sl":203}]},"test_50":{"methods":[{"sl":80}],"name":"testGetHobbies","pass":true,"statements":[{"sl":83},{"sl":85},{"sl":86},{"sl":87}]},"test_66":{"methods":[{"sl":119}],"name":"testIncrementSanity","pass":true,"statements":[{"sl":121},{"sl":122},{"sl":123},{"sl":124},{"sl":125},{"sl":126},{"sl":127},{"sl":128},{"sl":129},{"sl":130},{"sl":131}]},"test_93":{"methods":[{"sl":147}],"name":"testIncrementMight","pass":true,"statements":[{"sl":149},{"sl":150},{"sl":151},{"sl":152},{"sl":153},{"sl":154},{"sl":155},{"sl":156},{"sl":157},{"sl":158},{"sl":159},{"sl":160},{"sl":161}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [102], [], [102], [102], [102], [102], [102], [102], [102], [102], [102], [102], [102], [102], [], [], [33], [], [33], [], [], [36], [], [36], [], [], [142], [], [], [], [142], [], [], [108], [], [], [], [108], [], [], [50], [], [], [50], [], [50], [50], [50], [], [], [], [], [139], [], [139], [139], [139], [139], [139], [139], [139], [139], [139], [139], [139], [], [10], [], [10], [10], [10], [10], [10], [10], [10], [10], [10], [], [], [66], [], [66], [66], [66], [66], [66], [66], [66], [66], [66], [66], [66], [], [100], [], [100], [100], [100], [100], [100], [100], [100], [100], [100], [100], [100], [], [93], [], [93], [93], [93], [93], [93], [93], [93], [93], [93], [93], [93], [93], [93], [], [24], [], [24], [24], [24], [24], [24], [24], [24], [24], [24], [], [34], [], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [34], [], [46], [], [46], [46], [46], [46], [46], [46], [46], [46], [46], [], [], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [145], [145], [145], [145], [], [], [], [], []]