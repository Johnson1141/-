function Timetable(option) {

    this.el = document.querySelector(option.el);
    this.Timetables = option.timetables || [];
    this.week = option.week || [];
    this.merge = typeof option.merge === "boolean" ? option.merge: true;
    this.TimetableType = option.timetableType;
    this.leftHandText = [];
    this.highlightWeek = option.highlightWeek || "";
    this.gridOnClick = typeof option.gridOnClick === "function" ? option.gridOnClick: undefined;
    var styles = option.styles || {};
    this.leftHandWidth = styles.leftHandWidth || 40;
    this.Gheight = styles.Gheight || 48;
    this.defaultPalette = ["#f05261", "#48a8e4", "#ffd061", "#52db9a", "#70d3e6", "#52db9a", "#3f51b5", "#f3d147", "#4adbc3", "#673ab7", "#f3db49", "#76bfcd", "#b495e1", "#ff9800", "#8bc34a"];
    this.palette = (typeof styles.palette === "boolean" && !styles.palett) ? false: (styles.palette || []).concat(this.defaultPalette);

    this.deepCopyTimetableType=[];



    this.listMerge=[];
    this.paletteIndex=0;
    this._init = function() {

        for(i in this.TimetableType){
            var xx=this.TimetableType[i];
            this.deepCopyTimetableType[i]=[];
            for(var j=0;j<xx.length;j++)
                this.deepCopyTimetableType[i][j] = xx[j];
        }

        var TimetableTypeLength = this.TimetableType.length;
        this.Timetables.forEach(function(item, index) {
            if (item.length < TimetableTypeLength) {
                for (var i = 0; i < TimetableTypeLength - item.length; i++) {
                    item.push("")
                }
            }
        });



        var courseWrapper = document.createElement("div");
        courseWrapper.id = "courseWrapper";
        courseWrapper.style.position = "relative";
        courseWrapper.style.paddingLeft = this.leftHandWidth + "px";
        courseWrapper.style.border = "1px solid #dbdbdb";
        this.TimetableType.forEach(function(item, index) {
            item.unshift(index + 1)
        });
        var leftHand = document.createElement("div");
        leftHand.className = "Courses-leftHand";
        leftHand.style.position = "absolute";
        leftHand.style.left = 0;
        leftHand.style.top = 0;
        leftHand.style.width = this.leftHandWidth + "px";

        var timetable=[];
        for(var i=0;i<this.Timetables[0].length;i++){
            timetable[i] = [];
        }
        for(var i=0;i<this.Timetables.length;i++){
            for(var j=0;j<this.Timetables[i].length;j++){
                timetable[j][i] = this.Timetables[i][j];
            }
        }
        if (true) {
            var listMerge=[];
            this.Timetables.forEach(function(list, i) {
                if (!listMerge[i]) {
                    listMerge[i] = []
                }
                list.forEach(function(item, index) {
                    if (!index) {
                        return listMerge[i].push({
                            name: item,
                            length: 1
                        })
                    }
                    if (item === (listMerge[i][index - 1] || {}).name && item) {
                        var sameIndex = (listMerge[i][index - 1] || {}).sameIndex;
                        if (sameIndex || sameIndex === 0) {
                            listMerge[i][sameIndex].length++;
                            return listMerge[i].push({
                                name: item,
                                length: 0,
                                sameIndex: sameIndex
                            })
                        }
                        listMerge[i][index - 1].length++;
                        return listMerge[i].push({
                            name: item,
                            length: 0,
                            sameIndex: index - 1
                        })
                    } else {
                        return listMerge[i].push({
                            name: item,
                            length: 1
                        })
                    }
                })
            })
        }
        var head = document.createElement("div");
        head.style.overflow = "hidden";
        head.className = "Courses-head";
        week.forEach(function(item, index) {
            var weekItem = document.createElement("div");
            var highlightClass = this.highlightWeek === (index + 1) ? "highlight-week ": "";
            weekItem.className = highlightClass + "Courses-head-" + (index + 1);
            weekItem.innerText = item;
            weekItem.style.cssFloat = "left";
            weekItem.style.boxSizing = "border-box";
            weekItem.style.whiteSpace = "nowrap";
            weekItem.style.width = 100 / week.length + "%";
            head.appendChild(weekItem)
        });
        courseWrapper.appendChild(head);
        var courseListContent = document.createElement("div");
        courseListContent.className = "Courses-content";
        var palette = this.palette;
        var paletteIndex = this.paletteIndex;

        for(index in timetable){
            var values=timetable[index];
            var courseItems = document.createElement("ul");
            courseItems.style.listStyle = "none";
            courseItems.style.padding = "0px";
            courseItems.style.margin = "0px";
            courseItems.style.minHeight = this.Gheight + "px";
            courseItems.className = "stage_" + ((this.TimetableType[0] || [])[0] || "none"); --(this.TimetableType[0] || [])[2];
            if (! ((this.TimetableType[0] || [])[2])) {
                this.TimetableType.shift()
            }

            for(i in values){
                item = values[i];
                if (i > week.length - 1) {
                    return
                }
                var courseItem = document.createElement("li");
                courseItem.setAttribute("id", ""+i+"_"+index);
                courseItem.style.cssFloat = "left";
                courseItem.style.width = 100 / week.length + "%";
                courseItem.style.height = this.Gheight + "px";
                courseItem.style.boxSizing = "border-box";
                courseItem.style.position = "relative";
                if (listMerge[i][index].length > 1) {
                    var mergeDom = document.createElement("span");
                    mergeDom.style.position = "absolute";
                    mergeDom.style.zIndex = 9;
                    mergeDom.style.width = "94%";
                    mergeDom.style.height = this.Gheight * listMerge[i][index].length * 0.98+ "px";
                    mergeDom.style.left = "3%";
                    //mergeDom.style.right = 1;
                    mergeDom.style.top = "1%";
                    if (this.palette) {
                        mergeDom.style.backgroundColor = this.palette[paletteIndex];
                        mergeDom.style.color = "#fff";
                        paletteIndex++;

                        if (paletteIndex > palette.length) {
                            paletteIndex = 0
                        }
                    }
                    mergeDom.innerText = listMerge[i][index].name;
                    mergeDom.className = "course-hasContent";
                    courseItem.appendChild(mergeDom)
                } else {
                    if (this.merge && listMerge[i][index].length === 0) {
                        courseItem.innerText = ""
                    } else {
                        if (item && palette) {
                            courseItem.style.backgroundColor = palette[paletteIndex];
                            courseItem.style.color = "#fff";
                            paletteIndex++;
                            if (paletteIndex > palette.length) {
                                paletteIndex = 0
                            }
                        } else {
                            if (item) {
                                courseItem.className = "course-hasContent"
                            }
                        }
                        courseItem.innerText = item || ""
                    }
                }

                courseItems.appendChild(courseItem)
            }
            courseListContent.appendChild(courseItems);
        }
        this.listMerge=listMerge;
        this.paletteIndex=paletteIndex;
        courseWrapper.appendChild(courseListContent);
        courseWrapper.appendChild(leftHand);
        this.el.appendChild(courseWrapper);
        var courseItemDomHeight = (document.querySelector(".stage_1 li") || document.querySelector(".stage_none li")).offsetHeight;
        var coursesHeadDomHeight = document.querySelector(".Courses-head").offsetHeight;
        var leftHandTextDom = document.createElement("div");
        leftHandTextDom.className = "left-hand-TextDom";
        leftHandTextDom.style.height = coursesHeadDomHeight + "px";
        leftHandTextDom.style.boxSizing = "border-box";
        this.leftHandText.forEach(function(item) {
            var leftHandTextItem = document.createElement("div");
            leftHandTextItem.innerText = item;
            leftHandTextDom.appendChild(leftHandTextItem)
        });
        leftHand.appendChild(leftHandTextDom);

        this.deepCopyTimetableType.forEach(function(item, index) {
            var handItem = document.createElement("div");
            handItem.style.width = "100%";
            handItem.style.height = courseItemDomHeight * item[1] + "px";
            handItem.style.boxSizing = "border-box";
            if (typeof item[0] === "object") {
                for (var v in item[0]) {
                    var handItemInner = document.createElement("p");
                    handItemInner.innerText = item[0][v];
                    handItemInner.style.margin = "0px";
                    handItemInner.className = "left-hand-" + v;
                    handItem.appendChild(handItemInner)
                }
            } else {
                handItem.innerText = item[0] || ""
            }
            handItem.className = "left-hand-" + (index + 1);
            leftHand.appendChild(handItem)
        })
    },

        this.addcourse=function(val) {
            let st=val.st;
            let day=val.day;
            let len=val.len;

            //判断有没有冲突
            console.log(this.Timetables);
            for(let i=st-1;i<val.st+val.len-1;i++){
                let xx=this.Timetables;
                if(xx[val.day-1][i]!==""){
                    return false;
                }
            }

            for(var i=st-1;i<val.st+val.len-1;i++){
                this.Timetables[val.day-1][i]='placehold';
            }

            var mergeDom = document.createElement("span");
            mergeDom.style.position = "absolute";
            mergeDom.style.zIndex = 9;
            mergeDom.style.width = "94%";
            mergeDom.style.height = this.Gheight * val.len * 0.98+ "px";
            mergeDom.style.left = "3%";
            //mergeDom.style.right = 1;
            mergeDom.style.top = "1%";
            mergeDom.id = "place_"+day+"_"+st+"_"+len;
            var palette=this.palette;
            var paletteIndex= this.paletteIndex;
            if (palette) {
                mergeDom.style.backgroundColor = palette[paletteIndex];
                this.paletteIndex = (paletteIndex+1)%10;
                mergeDom.style.color = "#fff";
                paletteIndex++;
                if (paletteIndex > palette.length) {
                    paletteIndex = 0
                }
            }
            mergeDom.innerText = val.name;
            mergeDom.className = "course-hasContent";
            courseItem = document.getElementById(""+(val.day-1)+"_"+(val.st-1));
            courseItem.appendChild(mergeDom);
            console.log(this.Timetables);
            return true;
        },
        this.rmcourse=function(val){
            var flag=true;
            var st=val.st;
            var day=val.day;
            var len = val.len;
            var courseItem=document.getElementById("place_"+day+"_"+st+"_"+len);
            if(courseItem){
                var parent=courseItem.parentNode;
                parent.removeChild(courseItem);

                for(var i=st-1;i<val.st+val.len-1;i++){
                    this.Timetables[val.day-1][i]='';
                }
            }else{
                flag=false;
            }
            //console.log(this.Timetables);
            return flag;

        }
}
