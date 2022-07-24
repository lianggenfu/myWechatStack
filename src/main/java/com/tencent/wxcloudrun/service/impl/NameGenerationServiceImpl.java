package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.service.NameGenerationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NameGenerationServiceImpl implements NameGenerationService {

    private Object[] mid;
    private Object[] last;


    @Override
    public List<String> getName(String surName, int sexType, int number) {
        if(sexType==1){
            initBoyBase();
        }else if(sexType ==2 ){
            initGirlBase();
        }else{
            System.out.println("请选择宝宝的性别！！");
            return null;
        }
        List<String> result = new ArrayList<>(number);
        int midLength = mid.length;
        int lastLength = last.length;
        for (int i = 0; i < number ; i++) {
            StringBuffer sb = new StringBuffer(surName);
            int midRandom = (int) (Math.random() * midLength);
            midRandom = (midRandom*i*1000)%midLength;
            int lastRandom = (int) (Math.random() * lastLength);
            lastRandom = (lastRandom*i*1000)%lastLength;
            sb.append(mid[midRandom]).append(last[lastRandom]);
            result.add(sb.toString());
        }
        return result;
    }


    private void initGirlBase() {
        String[] strs = getGirlBaseName().split("、");
        Set<Character> setMid = new HashSet<>();
        Set<Character> setLast = new HashSet<>();
        for (int i = 0; i <strs.length ; i++) {
            String str = strs[i];
            setMid.add(str.charAt(0));
            setLast.add(str.charAt(1));
        }
        mid = setMid.stream().collect(Collectors.toList()).toArray();
        last = setLast.stream().collect(Collectors.toList()).toArray();
    }

    private String getGirlBaseName() {
        return "乐熙、锦千、梦静、绮倩、菡以、伊瑾、若馥、滢淇、若筠、恩冉、清璇、冉梵、淇知、欣丽、淇洁、惜虹、聪梦、璐丽、妤欣、丽汐、姗丽、妍卿、阳若、佳勤、茜怡、莉冉、璇乐、沛语、瑶岚、安奕、宛知、璇霄、馥伊、玥冉、瑗希、晴清、璐南、妍薇、琦思、蕾兰、馥阳、双千、若影、媛依、滢伊、如雯、娜娣、慕冉、勤思、悦甯、诗若、友念、逸琦、仪妍、妍苑、宛桐、瑞可、友诗、娜锦、依沛、向若、蓓馨、欣娜、冰以、娣绮、婧彩、妙兮、筠冉、颜甯、南璐、毓雨、玥璇、笑滢、蕾桐、叶向、以绮、筱甯、阳逸、颜婉、晓白、妙佳、诗沛、璐雨、馨婕、锦姬、萱晴、思筠、映宜、悦影、晶聪、涵伊、馨苑、玥馨、芙悦、艺恬、涵璐、婕涵、婉友、娴枫、乐彤、亦梦、璐卿、欣恩、咏佳、希滢、惜向、采晶、琼兮、瑾雯、晴琦、笑蓓、悦沁、筱碧、汐娴、紫卿、如双、黛影、璇丽、若向、蕾依、然冉、岚如、千若、然甜、兮沛、瑞平、雅向、梦涵、友思、希婕、眉卿、珞艺、筠芙、妙兰、觅梦、艺可、姝筠、蕾思、倩文、倩艺、玥宜、思颜、冰妍、希影、向馨、媛婕、娴雯、熙妤、璇婧、琬梓、璐婕、眉洋、莎婉、薇可、娇婕、仪汐、馥笑、梓含、琼蓉、甯卿、晴玥、宜玥、娴宝、蓝黛、飘汐、忆洁、静沛、婷爽、瑗玥、雅璐、恬若、蓓语、沛依、甜蓝、澜清、冉梦、颖思、涵初、珞彩、希姝、伊锦、苑琳、平颜、宜冰、冉瑾、嫣冉、蓝姗、姝恩、紫嫣、碧桐、滢倩、梵瑞、瑾沛、冰旋、欣蓉、觅眉、倩雅、菲颍、瑶菲、娴白、宛飞、伊琦、咏桐、倩艺、思平、玥依、初菡、汐易、绮友、颜冰、娇彩、依雯、映清、晓菲、冰平、若奕、瑾爽、虹聪、安薇、梵晓、玥容、梓姗、依雅、念灵、亦颍、芙瑾、黛瑗、娅思、甯娜、向璐、芙冉、滢妍、卿雯、映薇、宜妤、滢桐、雅绮、笑娴、桦梓、蕾佳、碧雯、夏汐、瑗熙、眉影、惜涵、雪金、卿蕾、蓝恬、蕾丽、蓝晓、晓颖、以宛、平平、如彩、冰伊、菲安、琦影、倩然、友瑶、姬思、滢然、蓉涵、馨倩、娅然、双雪、思冰、枫眉、晓蓓、然枫、以觅、菁娣、俪向、伊艺、颖忆、雯晴、希洁、碧飞、滢梦、涵洁、欣叶、雅恬、清沛、锦慕、以毓、若聪、知逸、娴妮、澜芙、嫣妍、瑞虹、影艺、友娇、妍蓉、以文、雨娇、慕甯、容逸、若颖、初冉、菁甯、雯欣、晴如";
    }

    public void initBoyBase() {
        String origin = "浩润、彬元、博弘、德佑、智远、晋哲、彬尚、轩棋、雨帆、杰洋、弘熙、\n" +
                "浩哲、俊绍、智月、宇灿、清乾、圣恒、哲舟、弘琪、韶华、荣庭、涛博、\n" +
                "旭泽、至海、涛文、弘羽、星磊、浩天、君谦、昌德、棋帆、宇帆、弘恒、\n" +
                "若溪、宇鹤、智翎、文鹤、昊柏、浩修、青林、昌耀、弘易、柯仁、万松、\n" +
                "全智、依振、睿圣、文义、棕德、天佑、博均、昌国、德欢、弘泰、浩璋、\n" +
                "博若、博亦、瀚帆、弘元、鸿润、圣伯、旭豪、棋天、晋辰、彤逸、晋拓、\n" +
                "瀚景、翰瑞、涛瀚、达鸣、文方、明耀、昌辉、天鸣、博远、涛影、文峻、\n" +
                "博奇、昌智、翰宇、瀚东、智新、翰尚、圣龙、文楷、君遥、杰融、韵皓、\n" +
                "展轩、辉宇、浩龙、文盛、德信、弥茂、俊桦、仁顺、旭柏、哲伦、致波、\n" +
                "志伟、明楷、文博、旭哲、文林、俊翰、圣琪、圣楠、光辉、月华、博仁、\n" +
                "晓奇、文青、博皓、远达、博昌、博帆、志材、寒远、彤玮、鼎辉、远松、\n" +
                "智城、星宇、博辰、云新、文语、怀德、泽杭、丰元、弘桦、庸玉、棋文、\n" +
                "柯依、寒云、秀楷、韵磊、江潮、君翔、志鹤、晋新、苑涛、强恒、寒霖、\n" +
                "博浩、依平、泽拓、泰耀、德桦、鸿灿、伟耀、浩善、伯灿、月硕、卓耀、\n" +
                "秀方、鸿祺、尚林、建琛、锐翔、远志、彬琪、靖元、森晖、景宸、朋宸、\n" +
                "淇方、峻浩、祉鑫、超耿、灿轩、柯昊、志天、文崇、瑾方、楠睿、琪硕、\n" +
                "泽宸、天嘉、少永、辰远、展超、轩驰、书驰、靖越、朋峻、博凯、展琦、\n" +
                "朋远、敬睿、裕琛、佑宏、景杰、祟召、卓港、天祺、玉轩、弥华、理博、\n" +
                "卓运、明岳、凡光、子淼、严谆、琪东、卓琦、谨丞、柏豪、展慈、益靖、\n" +
                "泽忠、瑾裕、雄靖、昊超、俊辰、千华、彬轩、超勋、尚靖、松毅、海晔、\n" +
                "浩浚、圣睿、祺云、益伟、材松、德霖、宇龙、新豪、峻超、祥博、少胜、\n" +
                "英方、文华、琪琛、丰逸、郜雄、雪桦、风宁、郜岩、展祥、耀羽、杰棠、\n" +
                "卓冰、丞聪、匀耀、勋宸、锐桦、潇泽、锦程、裕睿、伟羽、景松、修远、\n" +
                "凯若、晟循、衡骏、昊瑾、弥承、泷仁、弥睿、圣瑜、文瑜、林泽、天帆、\n" +
                "宁启、圣宁、志远、策匀、贻贤、昊帆、超利、英朴、月浩、江熙、尚尊、\n" +
                "卓玮、柏达、超雄、浩宝、家巧、鑫祺、建宸、瑾靖、超琪、景胜、郜坤、\n" +
                "鹏东、楠琛、益嘉、远尚、方伟、灿瑜、峻尚、哲铭、峻野、顺钧、峰瑜、\n" +
                "然耀、希嘉、禹浩、弥林、炜涛、轩启、汶銮、志文、宇任、强达、隆方、\n" +
                "材峻、贤睿、祺韬、康峰、浩润、宝超、益康、锐玮、泽齐、皓睿、元宇、\n" +
                "滨宸、尚勋、德润、浩睿、谷文、锐意、勋豪、康桦、强烁、宇东、浩宾、\n" +
                "书楠、远依、梓坤、文宸、晟嘉、渊浩、康朋、景睿、郜瑜、凡霖、楚洋、\n" +
                "贤语、晟丰、远高、昊浩、景旭、乐杉、勋烁、昊靖、海佳、锦航、力赫、\n" +
                "祟年、昊楠、昊业、春华、圣玮、德楚、予正、梓轩、景翔、琼辉、天崇、\n" +
                "松傲、朔示、展鹤、永望、钟果、奕楷、卓敬、楚文、棋鼎、禹泽、高年、\n" +
                "昊宇、木伟、智瑜、正涛、超刚、航弛、宏才、乐正、泰泓、松德、浩锦、\n" +
                "文琛、昌拓、智帆、玮遥、泽翔、昌恒、尧畅、俊义、桦鹤、博岩、涛旷、\n" +
                "杰洋、浩来、文阳、彤逸、涛东、泽易、俊辉、万松、文盛、世博、志峻、\n" +
                "秀辰、荣棋、霜波、贵博、泰辉、宇达、乾元、宇尘、睿博、昌崇、涛鸿、\n" +
                "文玉、博豪、俊玮、博玮、旭畅、翰润、智强、哲棋、晓涛、德业、泽胜、\n" +
                "浩泽、志清、玮坤、宇泰、孝德、远翰、玮云、朴诚、圣毅、玮桦、浩元、\n" +
                "昌信、君瑞、泰信、博昌、柏吉、松浩、劲鸿、宇轩、远图、文福、博诚、\n" +
                "晓诚、依夫、宁康、劲羽、桦瑜、昌皓、轩诚、韵磊、弥茂、荣辉、文尧、\n" +
                "方华、晨铭、展楠、凯珺、少仁、轩祥、轩召、少华、文豪、川豪、卓霖、\n" +
                "鸿月、玮楷、涛皓、健龙、啸傲、旭业、宇泽、泽云、涛锦、信野、凯风、\n" +
                "育德、昊楷、瀚维、圣文、海明、言明、涛琪、鸿涛、鼎承、文杭、新治、\n" +
                "君畅、俊伟、韵熙、睿轩、文轩、雨哲、哲玮、鼎恩、城久、明新、博奇、\n" +
                "远诚、鼎天、德星、彬琪、志逸、俊奇、韵瀚、亦温、宇诚、文璋、文嘉、\n" +
                "德琪、博睿、弥高、桦君、哲昌、鸿春、涛哲、恒德、俊维、玮新、世恒、\n" +
                "实新、晋尚、德诚、羽明、畅翔、俊城、泽新、依庆、悟瀚、柯望、博鹤、\n" +
                "棋羽、玮帆、青云、健德、棋博、丰瞻、博韵、玮恩、柏轩、泽城、泽石、\n" +
                "文逸、文熙、致浩、文冠、浩伦、圣云、智伦、彤豪、仁承、安辉、德楷、\n" +
                "圣涛、圣泽、博栋、昊哲、彬茂、雪柏、宇畅、棋桦、俊城、文风、桦君、\n" +
                "宇烟、荣天、棋雷、菲文、文嘉、德灿、君泰、宇泽、新志、羽晨、德业、\n" +
                "文运、鼎轩、世羽、益彤、涛乐、昊祺、泽天、俊倚、桦佑、俊轩、文俊、\n" +
                "智舟、博瑞、致鸿、苑羽、浩海、世高、俊哲、德道、博佑、君贤、达明、\n" +
                "远丰、宇栋、文庭、泰运、泰恒、圣德、志朋、宇承、昌信、博恩、乐轩、\n" +
                "彬义、晟宸、伯泽、志睿、智靖、轩雷、翰林、圣哲、旭玮、鼎智、文浩、\n" +
                "旭图、展翔、德灿、敬依";

        String[] strs = origin.replaceAll("\n","").split("、");
        Set<Character> setMid = new HashSet<>();
        Set<Character> setLast = new HashSet<>();
        for (int i = 0; i <strs.length ; i++) {
            String str = strs[i];
            setMid.add(str.charAt(0));
            setLast.add(str.charAt(1));
        }
        mid = setMid.stream().collect(Collectors.toList()).toArray();
        last = setLast.stream().collect(Collectors.toList()).toArray();
        System.out.println("初始化完成!!");
    }
}
