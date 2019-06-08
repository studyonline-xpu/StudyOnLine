#                             **在线学习API文档**

## 1.目录查询

***1.1.通过video_id查询是视屏章节*****

| api        | http://47.103.101.35:8080/study_online-manager-web/catalog/queryChapters?video_id={video_id} |
| ---------- | :----------------------------------------------------------- |
| 参数       | String    video_id                                           |
| 返回值类型 | List<Catalog>                                                |
| 功能       | 根据视屏的id查出视屏的所有章节                               |

```json
Catalog{
    catalogId	"1-1"                                  //章节id
    catalogName	"Python编程之基本方法"                   //章节名
    fatherId	"0"                                   //顶级章节目录 没有父章节所以为0
    isFather	true                                  //是父级目录 
    formerId	null                                  
    latterId	null
    videoId	"1"                                       //章节目录 所属的课程id
    uploadTime	1559634406000                         //章节创建时间
    videoUrl	""
}
```



***1.2.根据章节id查出所有的视屏目录***

| api        | http://47.103.101.35:8080/study_online-manager-web/catalog//queryVideoCatalog?chapter_id={chapter_id} |
| ---------- | ------------------------------------------------------------ |
| 参数       | String   chapter_id                                          |
| 返回值类型 | List<Catalog>                                                |
| 功能       | 根据章节Id查出视屏目录，每个目录对应着一个视屏               |

```
Catalog{
	catalogId	"1-1-1"                        //目录id
    catalogName	"课程内容和安排介绍"				 //目录名
    fatherId	"1-1"                          //父目录id
    isFather	false                          //是否为父级目录
    formerId	null                           //当前目录的前上一个目录（也就是上一个视屏）
    latterId	"1-1-2"                        //当前目录的前下一个目录（也就是下一个视屏）
    videoId	"1"                                //视屏Id
    uploadTime	1559634738000                  //目录创建时间
    videoUrl
    "http://101.132.78.78/group1/M00/00/00/rBOl6Vz2JESAKLDoAV_ulKXTIRI358.mp4"
    											//目录路径（视屏路径）
}
```

****

## 2.课程类型查询

***2.1.根据课程类型的父级目录查询子目录***

| api        | http://47.103.101.35:8080/study_online-manager-web/videoClass/queryVideoClassByFatherId?fatherId={fatherId} |
| ---------- | ------------------------------------------------------------ |
| 参数       | String   fatherId                                                     //父级课程类型的id |
| 返回值类型 | List<VideoClass>                                             |
| 功能       | 通过父目录id查询出所有的子目录。例：计算机（fatherId） -->编程语言 、数据结构、网络原理 |

```json
VideoClass{
	classId	"1"
    className	"计算机"
    fatherId	"0"
    isFather	true
}

{
	classId	"10"
	className	"工学"
	fatherId	"0"
	isFather	true
}
```



## 3.查询课程

***3.1.根据课程类型查询所有的课程***

| api        | http://47.103.101.35:8080/study_online-manager-web/video/queryVideoByClassId?calssId={classId} |
| ---------- | ------------------------------------------------------------ |
| 参数       | String  classId                                                            //课程的类型id |
| 返回值类型 | List<Video>                                                  |
| 功能       | 通过课程类型查询出所有的该类课程。例：数据结构（classId）下有很多个不同作者的作品，比如王爱丽的数据结构、张旭峰的数据结构。 |

```
Video{
	videoId	"2"                                           //课程id
    videoName	"心理学入门"                                //课程名称
    userId	"13571890522"                                 //作者id
    classId	"3"                                           //课程所属的类型的id
    uploadTime	1559634005000  							  //视屏上传时间
    updateTime	1559634009000							  //视屏更新时间
    price	0											  //视屏的价格
    clicks	12											  //视屏的播放量
    collections	0                                         //收藏量
    likes      12                                         //点赞量
    //课程简介
    note	"心理学入门》课程旨在为初学者学习心理学提供知识框架和知识基础，同时完成对学习者的心理素质结构的潜在优化。本课程主要包括三部分内容：第一，心理学概述，主要对科学心理学的研究对象、研究内容、研究方法等进行了介绍；第二，心理学基本概念，主要对感觉、知觉、记忆、思维、情绪、智力、人格等概念进行讲解；第三，心理学基本理论，主要对认知理论 、问题解决理论、动机理论、学习理论等心理学基本理论进行阐释。在阐述各部分内容时，本课程注重基本概念、基本理论和基本规律的分析和详解，注意理论与实践的相结合，注重心理学知识在实践领域中的应用本课程所讲授的心理学概念、原理和规律等具有一定的实用性，对于学生认知自身的心理状态，检测自身的心理健康情况有辅助作用。课程偏重于与学习相关的心理规律与理论的讲解，为学习者进行专业学习提供方法论。同时，本课程结合一些学生群体中发生的具体案例，对学生有警示和提醒作用。"
    //视屏路径
    picture	"http://101.132.78.78/group1/M00/00/00/rBOl6Vz3auyAdkIoAAHVeRFCbFY363.png"

}
```

***3.2查询热门课程***

| api        | http://47.103.101.35:8080/study_online-manager-web/video/queryHotVideo |
| ---------- | ------------------------------------------------------------ |
| 参数       | 无                                                           |
| 返回值类型 | List<Video>                                                  |
| 功能       | 查询出热门课程，用在首页推荐                                 |

