package freemusic.music.pojo.wy


data class NeteaseLostSong(
        var code: Int = 0,
        var album: AlbumBeanX? = null
) {
    data class AlbumBeanX(
            var paid: Boolean = false,
            var onSale: Boolean = false,
            var commentThreadId: String? = null,
            var picId: Long = 0,
            var briefDesc: String? = null,
            var publishTime: Long = 0,
            var company: String? = null,
            var artist: ArtistBean? = null,
            var picUrl: String? = null,
            var copyrightId: Int = 0,
            var status: Int = 0,
            var blurPicUrl: String? = null,
            var companyId: Int = 0,
            var pic: Long = 0,
            var tags: String? = null,
            var description: String? = null,
            var subType: String? = null,
            var name: String? = null,
            var id: Int = 0,
            var type: String? = null,
            var size: Int = 0,
            var info: InfoBean? = null,
            var songs: List<SongsBean>? = null,
            var artists: List<ArtistsBeanXX>? = null,
            var alias: List<String>? = null
    ) {
        data class ArtistBean(
                var img1v1Id: Long = 0,
                var topicPerson: Int = 0,
                var picId: Long = 0,
                var briefDesc: String? = null,
                var albumSize: Int = 0,
                var img1v1Url: String? = null,
                var trans: String? = null,
                var picUrl: String? = null,
                var musicSize: Int = 0,
                var name: String? = null,
                var id: Int = 0,
                var picId_str: String? = null,
                var img1v1Id_str: String? = null,
                var alias: List<*>? = null,
                var transNames: List<String>? = null
        )

        data class InfoBean(
                var liked: Boolean = false,
                var comments: Any? = null,
                var resourceType: Int = 0,
                var resourceId: Int = 0,
                var commentCount: Int = 0,
                var shareCount: Int = 0,
                var likedCount: Int = 0,
                var threadId: String? = null
        )

        data class SongsBean(
                var starred: Boolean = false,
                var popularity: Double = 0.toDouble(),
                var starredNum: Int = 0,
                var playedNum: Int = 0,
                var dayPlays: Int = 0,
                var hearTime: Int = 0,
                var mp3Url: String? = null,
                var rtUrls: Any? = null,
                var fee: Int = 0,
                var commentThreadId: String? = null,
                var hMusic: HMusicBean? = null,
                var mMusic: MMusicBean? = null,
                var lMusic: LMusicBean? = null,
                var album: AlbumBean? = null,
                var mvid: Int = 0,
                var ftype: Int = 0,
                var rtype: Int = 0,
                var rurl: Any? = null,
                var copyFrom: String? = null,
                var score: Int = 0,
                var copyrightId: Int = 0,
                var status: Int = 0,
                var disc: String? = null,
                var crbt: Any? = null,
                var bMusic: BMusicBean? = null,
                var rtUrl: Any? = null,
                var position: Int = 0,
                var duration: Int = 0,
                var audition: Any? = null,
                var ringtone: Any? = null,
                var no: Int = 0,
                var name: String? = null,
                var id: Int = 0,
                var artist: List<ArtistsBeanX>? = null,
                var alias: List<*>? = null,
                var transNames: List<String>? = null
        ) {
            data class HMusicBean(
                    var playTime: Int = 0,
                    var bitrate: Int = 0,
                    var dfsId: Long = 0,
                    var sr: Int = 0,
                    var volumeDelta: Double = 0.toDouble(),
                    var name: Any? = null,
                    var id: Int = 0,
                    var size: Int = 0,
                    var extension: String? = null,
                    var dfsId_str: String? = null
            )

            data class MMusicBean(
                    var playTime: Int = 0,
                    var bitrate: Int = 0,
                    var dfsId: Long = 0,
                    var sr: Int = 0,
                    var volumeDelta: Double = 0.toDouble(),
                    var name: Any? = null,
                    var id: Int = 0,
                    var size: Int = 0,
                    var extension: String? = null
            )

            data class LMusicBean(
                    var playTime: Int = 0,
                    var bitrate: Int = 0,
                    var dfsId: Long = 0,
                    var sr: Int = 0,
                    var volumeDelta: Double = 0.toDouble(),
                    var name: Any? = null,
                    var id: Int = 0,
                    var size: Int = 0,
                    var extension: String? = null,
                    var dfsId_str: String? = null
            )

            data class AlbumBean(
                    var paid: Boolean = false,
                    var onSale: Boolean = false,
                    var commentThreadId: String? = null,
                    var picId: Long = 0,
                    var briefDesc: String? = null,
                    var publishTime: Long = 0,
                    var company: String? = null,
                    var artist: ArtistBeanX? = null,
                    var picUrl: String? = null,
                    var copyrightId: Int = 0,
                    var status: Int = 0,
                    var blurPicUrl: String? = null,
                    var companyId: Int = 0,
                    var pic: Long = 0,
                    var tags: String? = null,
                    var description: String? = null,
                    var subType: String? = null,
                    var name: String? = null,
                    var id: Int = 0,
                    var type: String? = null,
                    var size: Int = 0,
                    var songs: List<*>? = null,
                    var artists: List<ArtistsBean>? = null,
                    var alias: List<String>? = null
            ) {
                data class ArtistBeanX(
                        var img1v1Id: Long = 0,
                        var topicPerson: Int = 0,
                        var picId: Int = 0,
                        var briefDesc: String? = null,
                        var albumSize: Int = 0,
                        var img1v1Url: String? = null,
                        var trans: String? = null,
                        var picUrl: String? = null,
                        var musicSize: Int = 0,
                        var name: String? = null,
                        var id: Int = 0,
                        var img1v1Id_st: String,
                        var alias: List<*>? = null
                )

                data class ArtistsBean(
                        var img1v1Id: Long = 0,
                        var topicPerson: Int = 0,
                        var picId: Int = 0,
                        var briefDesc: String? = null,
                        var albumSize: Int = 0,
                        var img1v1Url: String? = null,
                        var trans: String? = null,
                        var picUrl: String? = null,
                        var musicSize: Int = 0,
                        var name: String? = null,
                        var id: Int = 0,
                        var img1v1Id_str: String,
                        var alias: List<*>? = null
                )
            }

            data class BMusicBean(
                    var playTime: Int = 0,
                    var bitrate: Int = 0,
                    var dfsId: Long = 0,
                    var sr: Int = 0,
                    var volumeDelta: Double = 0.toDouble(),
                    var name: Any? = null,
                    var id: Int = 0,
                    var size: Int = 0,
                    var extension: String? = null,
                    var dfsId_str: String? = null
            )

            data class ArtistsBeanX(
                    var img1v1Id: Long = 0,
                    var topicPerson: Int = 0,
                    var picId: Int = 0,
                    var briefDesc: String? = null,
                    var albumSize: Int = 0,
                    var img1v1Url: String? = null,
                    var trans: String? = null,
                    var picUrl: String? = null,
                    var musicSize: Int = 0,
                    var name: String? = null,
                    var id: Int = 0,
                    var img1v1Id_str: String? = null,
                    var alias: List<*>? = null
            )
        }

        data class ArtistsBeanXX(
                var img1v1Id: Long = 0,
                var topicPerson: Int = 0,
                var picId: Int = 0,
                var briefDes: String,
                var albumSize: Int = 0,
                var img1v1Ur: String,
                var trans: String? = null,
                var picUrl: String? = null,
                var musicSize: Int = 0,
                var name: String? = null,
                var id: Int = 0,
                var img1v1Id_str: String,
                var alias: List<*>? = null
        )


    }
}
