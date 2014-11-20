import java.io.File

def findFile(dirName) {
	def dir = new File(dirName)
	if (dir.isDirectory()) {
		dir.eachFileRecurse { file ->
			reName(file)
		}
	}else{
		reName(dir)
	}
}

def reName(file){
	if(file.getPath().contains("ic_home")){
		def filePath = file.getPath().replaceAll("ic_home","ic_screen")
		def newF = new File(filePath)
		println newF.getPath()
 		file.renameTo(newF)
		println file.getName()
}

screens = 9;
mScreenCountX = 3;
mScreenCountY = 3;
def mNumScreenPages = (int) Math.ceil((int)(screens / (mScreenCountX * mScreenCountY)));
println mNumScreenPages;


//findFile("/home/zhou/Pictures/5Q桌面/workspace")
//filePath.replace(dir:"dirName", includes:"*.png", token:"tokenName", value:"${screen}")