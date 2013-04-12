var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":501,"id":66,"methods":[{"el":122,"sc":2,"sl":98},{"el":128,"sc":2,"sl":124},{"el":138,"sc":2,"sl":130},{"el":147,"sc":2,"sl":140},{"el":154,"sc":2,"sl":149},{"el":161,"sc":2,"sl":156},{"el":166,"sc":2,"sl":163},{"el":173,"sc":2,"sl":168},{"el":180,"sc":2,"sl":175},{"el":185,"sc":2,"sl":182},{"el":194,"sc":2,"sl":187},{"el":201,"sc":2,"sl":196},{"el":208,"sc":2,"sl":203},{"el":213,"sc":2,"sl":210},{"el":222,"sc":2,"sl":215},{"el":229,"sc":2,"sl":224},{"el":236,"sc":2,"sl":231},{"el":241,"sc":2,"sl":238},{"el":249,"sc":2,"sl":242},{"el":256,"sc":2,"sl":251},{"el":263,"sc":2,"sl":258},{"el":268,"sc":2,"sl":265},{"el":276,"sc":2,"sl":270},{"el":285,"sc":2,"sl":278},{"el":290,"sc":2,"sl":287},{"el":297,"sc":2,"sl":292},{"el":304,"sc":2,"sl":299},{"el":309,"sc":2,"sl":306},{"el":318,"sc":2,"sl":311},{"el":335,"sc":2,"sl":330},{"el":342,"sc":2,"sl":337},{"el":347,"sc":2,"sl":344},{"el":356,"sc":2,"sl":349},{"el":363,"sc":2,"sl":358},{"el":370,"sc":2,"sl":365},{"el":375,"sc":2,"sl":372},{"el":384,"sc":2,"sl":377},{"el":391,"sc":2,"sl":386},{"el":398,"sc":2,"sl":393},{"el":403,"sc":2,"sl":400},{"el":412,"sc":2,"sl":405},{"el":419,"sc":2,"sl":414},{"el":426,"sc":2,"sl":421},{"el":431,"sc":2,"sl":428},{"el":440,"sc":2,"sl":433},{"el":447,"sc":2,"sl":442},{"el":454,"sc":2,"sl":449},{"el":459,"sc":2,"sl":456},{"el":468,"sc":2,"sl":461},{"el":475,"sc":2,"sl":470},{"el":482,"sc":2,"sl":477},{"el":487,"sc":2,"sl":484},{"el":499,"sc":2,"sl":490}],"name":"TestOmenCard","sl":42}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":251}],"name":"IsHauntRollWithSpear","pass":true,"statements":[{"sl":253},{"sl":254},{"sl":255}]},"test_101":{"methods":[{"sl":490}],"name":"DogInit","pass":true,"statements":[{"sl":492},{"sl":493},{"sl":494},{"sl":495}]},"test_107":{"methods":[{"sl":270}],"name":"SpearInit","pass":true,"statements":[{"sl":272},{"sl":273},{"sl":274},{"sl":275}]},"test_11":{"methods":[{"sl":456}],"name":"TestWhatToDoForHolySymbol","pass":true,"statements":[{"sl":458}]},"test_110":{"methods":[{"sl":306}],"name":"TestWhatToDoForMask","pass":true,"statements":[{"sl":308}]},"test_115":{"methods":[{"sl":258}],"name":"MakeAHauntRollWithSpear","pass":true,"statements":[{"sl":260},{"sl":261},{"sl":262}]},"test_118":{"methods":[{"sl":175}],"name":"MakeAHauntRollWithBook","pass":true,"statements":[{"sl":177},{"sl":178},{"sl":179}]},"test_121":{"methods":[{"sl":484}],"name":"TestWhatToDoForDog","pass":true,"statements":[{"sl":486}]},"test_127":{"methods":[{"sl":414}],"name":"IsHauntRollWithSkull","pass":true,"statements":[{"sl":416},{"sl":417},{"sl":418}]},"test_128":{"methods":[{"sl":470}],"name":"IsHauntRollWithDog","pass":true,"statements":[{"sl":472},{"sl":473},{"sl":474}]},"test_133":{"methods":[{"sl":477}],"name":"MakeAHauntRollWithDog","pass":true,"statements":[{"sl":479},{"sl":480},{"sl":481}]},"test_134":{"methods":[{"sl":149}],"name":"IsHauntRollWithCrystalBall","pass":true,"statements":[{"sl":151},{"sl":152},{"sl":153}]},"test_135":{"methods":[{"sl":163}],"name":"TestWhatToDoForCrystalBall","pass":true,"statements":[{"sl":165}]},"test_136":{"methods":[{"sl":405}],"name":"BiteInit","pass":true,"statements":[{"sl":407},{"sl":408},{"sl":409},{"sl":410}]},"test_14":{"methods":[{"sl":400}],"name":"TestWhatToDoForBite","pass":true,"statements":[{"sl":402}]},"test_141":{"methods":[{"sl":449}],"name":"MakeAHauntRollWithHolySymbol","pass":true,"statements":[{"sl":451},{"sl":452},{"sl":453}]},"test_144":{"methods":[{"sl":265}],"name":"TestWhatToDoForSpear","pass":true,"statements":[{"sl":267}]},"test_148":{"methods":[{"sl":311}],"name":"MaskInit","pass":true,"statements":[{"sl":313},{"sl":314},{"sl":315},{"sl":316}]},"test_15":{"methods":[{"sl":278}],"name":"SpiritBoardInit","pass":true,"statements":[{"sl":280},{"sl":281},{"sl":282},{"sl":283}]},"test_16":{"methods":[{"sl":231}],"name":"MakeAHauntRollWithMadman","pass":true,"statements":[{"sl":233},{"sl":234},{"sl":235}]},"test_27":{"methods":[{"sl":215}],"name":"RingInit","pass":true,"statements":[{"sl":217},{"sl":218},{"sl":219},{"sl":220}]},"test_30":{"methods":[{"sl":187}],"name":"BookInit","pass":true,"statements":[{"sl":189},{"sl":190},{"sl":191},{"sl":192}]},"test_35":{"methods":[{"sl":156}],"name":"MakeAHauntRollWithCrystalBall","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":160}]},"test_37":{"methods":[{"sl":421}],"name":"MakeAHauntRollWithSkull","pass":true,"statements":[{"sl":423},{"sl":424},{"sl":425}]},"test_38":{"methods":[{"sl":140}],"name":"CrystalBallOmenInit","pass":true,"statements":[{"sl":142},{"sl":143},{"sl":144},{"sl":145}]},"test_41":{"methods":[{"sl":287}],"name":"TestWhatToDoForSpiritBoard","pass":true,"statements":[{"sl":289}]},"test_45":{"methods":[{"sl":344}],"name":"TestWhatToDoForMedallion","pass":true,"statements":[{"sl":346}]},"test_47":{"methods":[{"sl":224}],"name":"IsHauntRollWithMadman","pass":true,"statements":[{"sl":226},{"sl":227},{"sl":228}]},"test_53":{"methods":[{"sl":168}],"name":"IsHauntRollWithBook","pass":true,"statements":[{"sl":170},{"sl":171},{"sl":172}]},"test_54":{"methods":[{"sl":130}],"name":"TestMakeHauntRollForOmenCard","pass":true,"statements":[{"sl":132},{"sl":133},{"sl":134},{"sl":135},{"sl":136}]},"test_56":{"methods":[{"sl":461}],"name":"HolySymbolInit","pass":true,"statements":[{"sl":463},{"sl":464},{"sl":465},{"sl":466}]},"test_57":{"methods":[{"sl":358}],"name":"IsHauntRollWithGirl","pass":true,"statements":[{"sl":360},{"sl":361},{"sl":362}]},"test_58":{"methods":[{"sl":442}],"name":"IsHauntRollWithHolySymbol","pass":true,"statements":[{"sl":444},{"sl":445},{"sl":446}]},"test_59":{"methods":[{"sl":386}],"name":"IsHauntRollWithBite","pass":true,"statements":[{"sl":388},{"sl":389},{"sl":390}]},"test_61":{"methods":[{"sl":299}],"name":"MakeAHauntRollWithMask","pass":true,"statements":[{"sl":301},{"sl":302},{"sl":303}]},"test_62":{"methods":[{"sl":377}],"name":"GirlInit","pass":true,"statements":[{"sl":379},{"sl":380},{"sl":381},{"sl":382}]},"test_65":{"methods":[{"sl":196}],"name":"IsHauntRollWithRing","pass":true,"statements":[{"sl":198},{"sl":199},{"sl":200}]},"test_69":{"methods":[{"sl":330}],"name":"IsHauntRollWithMedallion","pass":true,"statements":[{"sl":332},{"sl":333},{"sl":334}]},"test_70":{"methods":[{"sl":203}],"name":"MakeAHauntRollWithRing","pass":true,"statements":[{"sl":205},{"sl":206},{"sl":207}]},"test_74":{"methods":[{"sl":242}],"name":"MadmanInit","pass":true,"statements":[{"sl":244},{"sl":245},{"sl":246},{"sl":247}]},"test_75":{"methods":[{"sl":393}],"name":"MakeAHauntRollWithBite","pass":true,"statements":[{"sl":395},{"sl":396},{"sl":397}]},"test_77":{"methods":[{"sl":428}],"name":"TestWhatToDoForSkull","pass":true,"statements":[{"sl":430}]},"test_8":{"methods":[{"sl":238}],"name":"TestWhatToDoForMadman","pass":true,"statements":[{"sl":240}]},"test_80":{"methods":[{"sl":372}],"name":"TestWhatToDoForGirl","pass":true,"statements":[{"sl":374}]},"test_82":{"methods":[{"sl":349}],"name":"MedallionInit","pass":true,"statements":[{"sl":351},{"sl":352},{"sl":353},{"sl":354}]},"test_83":{"methods":[{"sl":182}],"name":"TestWhatToDoForBook","pass":true,"statements":[{"sl":184}]},"test_87":{"methods":[{"sl":292}],"name":"IsHauntRollWithMask","pass":true,"statements":[{"sl":294},{"sl":295},{"sl":296}]},"test_88":{"methods":[{"sl":124}],"name":"TestIsHauntRollForOmenCard","pass":true,"statements":[{"sl":126},{"sl":127}]},"test_91":{"methods":[{"sl":433}],"name":"SkullInit","pass":true,"statements":[{"sl":435},{"sl":436},{"sl":437},{"sl":438}]},"test_94":{"methods":[{"sl":210}],"name":"TestWhatToDoForRing","pass":true,"statements":[{"sl":212}]},"test_97":{"methods":[{"sl":365}],"name":"MakeAHauntRollWithGirl","pass":true,"statements":[{"sl":367},{"sl":368},{"sl":369}]},"test_99":{"methods":[{"sl":337}],"name":"MakeAHauntRollWithMedallion","pass":true,"statements":[{"sl":339},{"sl":340},{"sl":341}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [88], [], [88], [88], [], [], [54], [], [54], [54], [54], [54], [54], [], [], [], [38], [], [38], [38], [38], [38], [], [], [], [134], [], [134], [134], [134], [], [], [35], [], [35], [35], [35], [], [], [135], [], [135], [], [], [53], [], [53], [53], [53], [], [], [118], [], [118], [118], [118], [], [], [83], [], [83], [], [], [30], [], [30], [30], [30], [30], [], [], [], [65], [], [65], [65], [65], [], [], [70], [], [70], [70], [70], [], [], [94], [], [94], [], [], [27], [], [27], [27], [27], [27], [], [], [], [47], [], [47], [47], [47], [], [], [16], [], [16], [16], [16], [], [], [8], [], [8], [], [74], [], [74], [74], [74], [74], [], [], [], [0], [], [0], [0], [0], [], [], [115], [], [115], [115], [115], [], [], [144], [], [144], [], [], [107], [], [107], [107], [107], [107], [], [], [15], [], [15], [15], [15], [15], [], [], [], [41], [], [41], [], [], [87], [], [87], [87], [87], [], [], [61], [], [61], [61], [61], [], [], [110], [], [110], [], [], [148], [], [148], [148], [148], [148], [], [], [], [], [], [], [], [], [], [], [], [], [], [69], [], [69], [69], [69], [], [], [99], [], [99], [99], [99], [], [], [45], [], [45], [], [], [82], [], [82], [82], [82], [82], [], [], [], [57], [], [57], [57], [57], [], [], [97], [], [97], [97], [97], [], [], [80], [], [80], [], [], [62], [], [62], [62], [62], [62], [], [], [], [59], [], [59], [59], [59], [], [], [75], [], [75], [75], [75], [], [], [14], [], [14], [], [], [136], [], [136], [136], [136], [136], [], [], [], [127], [], [127], [127], [127], [], [], [37], [], [37], [37], [37], [], [], [77], [], [77], [], [], [91], [], [91], [91], [91], [91], [], [], [], [58], [], [58], [58], [58], [], [], [141], [], [141], [141], [141], [], [], [11], [], [11], [], [], [56], [], [56], [56], [56], [56], [], [], [], [128], [], [128], [128], [128], [], [], [133], [], [133], [133], [133], [], [], [121], [], [121], [], [], [], [101], [], [101], [101], [101], [101], [], [], [], [], [], []]