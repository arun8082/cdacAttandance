package fillAttandanceSystem;

import java.util.Arrays;

public class Test {
	static int j=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=",0.18499367,,0.01010872,,0.05967192,,0.21780795,,0.06401781,-0.09694621\r\n" + 
				",,-0.02273024,-0.07920409,-0.1632465,,-0.06242509,,0.20131549,,0.02862481\r\n" + 
				",,-0.04016721,,0.17714901,,0.06038287,,0.07489635,,0.11374742,,0.16430318\r\n" + 
				",,,0.05169333,-0.05472623,-0.02766441,,0.0157764,,,0.10024914,-0.04063419\r\n" + 
				",,,0.06576135,,0.04264692,-0.03969842,,0.01972499,-0.04484443,,0.10710002\r\n" + 
				",,-0.04057112,-0.0431929,,,0.00120337,,0.02301318,-0.01185138,-0.12314437\r\n" + 
				",,,0.01275888,-0.07453886,-0.03830642,,0.05364829,,0.08340184,-0.00192994\r\n" + 
				",,,0.16397156,-0.07405579,-0.02790023,-0.00194194,,0.06157074,,0.0538631\r\n" + 
				",,,0.04036142,-0.13565043,-0.00511866,,0.03983696,,0.00773312,-0.15641715\r\n" + 
				",,-0.20310141,,0.13480397,-0.00378607,-0.01914833,,0.00788904,-0.04227419\r\n" + 
				",,,0.10801286,-0.12027068,-0.08755796,,0.08695091,-0.00246122,,0.01132062\r\n" + 
				",,,0.02987638,,0.12878695,-0.11515402,-0.04138936,,0.07328834,-0.0469036\r\n" + 
				",,-0.07322165,-0.1086572,,,0.10665531,,0.02184335,,0.06013235,,0.16844349\r\n" + 
				",,,0.0463501,,,0.02952955,-0.10079466,,0.10634598,,0.0754161,,-0.07725793\r\n" + 
				",,-0.05434881,,0.1669358,,,0.00342361,-0.1790029,,,0.04112671,-0.04284463\r\n" + 
				",,-0.02346162,,0.0698458,,-0.03211876,-0.12526622,,0.12375453,-0.03161035\r\n" + 
				",,,0.08605326,-0.05307532,-0.07216152,,0.16851951,,0.1415331,,-0.04802546\r\n" + 
				",,-0.02315004,-0.07837428,-0.10286551,,0.0724749,,-0.14250422,-0.05909933\r\n" + 
				",,-0.05940653,,0.08211727,-0.16253954,,0.099459,,,,0.01397905,-0.06084979\r\n" + 
				",,-0.04204606,,0.00090884,-0.07231908,,0.10473716,,0.05276007,-0.06806775\r\n" + 
				",,,0.10297707,,0.00668259,-0.1126344,,,0.0815808,,-0.02183541,,0.06308419\r\n" + 
				",,-0.06742598,,0.07360801";
					    
		String str2="-0.118750341236591,0.113604478538036,0.0912592113018036,-0.0971237942576408,-0.0753114446997643,-0.00404656725004315,0.0298469755798578,\r\n" + 
				"-0.0109586045145988,0.111995831131935,-0.0304871518164873,0.239000245928764,-0.00312783475965261,-0.267123609781265,-0.122463762760162,\r\n" + 
				"-0.0293968115001917,0.0804834142327309,-0.132495164871216,-0.0547220855951309,-0.135444834828377,-0.102030798792839,0.0616848431527615,\r\n" + 
				"0.0156009923666716,-0.00024765043053776,-0.0294199287891388,-0.0974850207567215,-0.380863547325134,-0.0191067382693291,-0.101470664143562,\r\n" + 
				"-0.0488682202994823,-0.142499774694443,0.0194978639483452,0.031070539727807,-0.142700865864754,-0.0590525567531586,-0.0473146960139275,\r\n" + 
				"0.0549966469407082,-0.0386424735188484,-0.0574612580239773,0.110813915729523,-0.0376280769705772,-0.113948091864586,-0.0329962410032749,\r\n" + 
				"0.0319054313004017,0.256763815879822,0.226246938109398,0.0537704788148403,0.00396724790334702,-0.0415355637669563,0.14542581140995,\r\n" + 
				"-0.299819469451904,0.0606670305132866,0.0985656827688217,0.0764443576335907,0.025488493964076,0.121242821216583,-0.10094528645277,\r\n" + 
				"-0.00611631106585264,0.0555437803268433,-0.169282525777817,0.0155118303373456,0.011024272069335,-0.100541196763515,-0.118264108896255,\r\n" + 
				"-0.140375167131424,0.206737741827965,0.0990018621087074,-0.162723645567894,-0.0579852610826492,0.117012098431587,-0.134933397173882,\r\n" + 
				"-0.0352211147546768,0.00286075286567211,-0.108366936445236,-0.163675114512444,-0.273707836866379,0.138165488839149,0.409574210643768,\r\n" + 
				"0.186405867338181,-0.193522334098816,-0.025781661272049,-0.119753532111645,0.0214412920176983,0.070718452334404,0.0557030737400055,\r\n" + 
				"-0.110996074974537,0.00790562853217125,-0.100901387631893,0.0582283213734627,0.113250516355038,-0.0395437926054001,-0.0838317200541496,\r\n" + 
				"0.223587363958359,-0.0318335480988026,0.0672411620616913,0.0169702377170324,0.00660179555416107,-0.112160935997963,0.0307646337896585,\r\n" + 
				"-0.0978876277804375,0.0195675268769264,0.171645432710648,-0.146601930260658,0.0124437194317579,0.101775713264942,-0.122864834964275,\r\n" + 
				"0.113308630883694,-0.0346439629793167,0.0494540818035603,0.0872176364064217,-0.0480909161269665,-0.10665400326252,-0.0594000965356827,\r\n" + 
				"0.14290477335453,-0.22108656167984,0.161567330360413,0.174730494618416,0.00238140556029975,0.157511696219444,0.111105710268021,0.0704015865921974,\r\n" + 
				"0.00911845825612545,-0.00277903862297535,-0.153124138712883,-0.0464902929961681,0.0758806169033051,0.0198370255529881,0.0479274317622185,0.00257362611591816";
		
		String[] d = str2.split(",");
		//Arrays.stream(d).filter(i->i!=null || i!= "").forEach(i->System.out.println(j++ +":"+i));
		for (String string : d) {
			String str1= string.trim();
			if(str1!=null && str1!="" && !str1.isEmpty()) {
				//if()
				System.out.println(j++ +":"+str1);
			}
		}
	}

}