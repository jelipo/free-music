package freemusic.music.pojo.qq

data class TencentMvData(
        var dltype: Int = 0,
        var exem: Int = 0,
        var fl: FlBean = FlBean(),
        var hs: Int = 0,
        var ip: String? = null,
        var ls: Int = 0,
        var preview: Int = 0,
        var s: String? = null,
        var sfl: SflBean? = null,
        var tm: Int = 0,
        var vl: VlBean = VlBean()
) {
    data class FlBean(
            var cnt: Int = 0,
            var fi: List<FiBean> = ArrayList(0)
    ) {
        data class FiBean(
                var br: Int = 0,
                var cname: String? = null,
                var fs: Int = 0,
                var id: Int = 0,
                var lmt: Int = 0,
                var name: String = "",
                var sb: Int = 0,
                var sl: Int = 0
        )
    }

    data class SflBean(
            var cnt: Int
    )

    data class VlBean(
            var cnt: Int = 0,
            var vi: List<ViBean>? = null
    )

    data class ViBean(
            var br: Int = 0,
            var ch: Int = 0,
            var cl: ClBean? = null,
            var ct: Int = 0,
            var drm: Int = 0,
            var dsb: Int = 0,
            var fclip: Int = 0,
            var fmd5: String? = null,
            var fn: String? = null,
            var fs: Int = 0,
            var fst: Int = 0,
            var fvkey: String? = null,
            var hevc: Int = 0,
            var iflag: Int = 0,
            var level: Int = 0,
            var lnk: String? = null,
            var logo: Int = 0,
            var share: Int = 0,
            var sp: Int = 0,
            var st: Int = 0,
            var td: String? = null,
            var ti: String? = null,
            var type: Int = 0,
            var ul: UlBean? = null,
            var vh: Int = 0,
            var vid: String? = null,
            var videotype: Int = 0,
            var vst: Int = 0,
            var vw: Int = 0,
            var pl: List<PlBean>? = null
    ) {
        data class ClBean(
                var fc: Int = 0,
                var ci: List<CiBean>? = null
        ) {
            data class CiBean(
                    var cd: String? = null,
                    var cmd5: String? = null,
                    var cs: Int = 0,
                    var idx: Int = 0,
                    var keyid: String? = null
            )
        }

        data class UlBean(
                var ui: List<UiBean>? = null
        ) {
            data class UiBean(
                    var dt: Int = 0,
                    var dtc: Int = 0,
                    var url: String? = null,
                    var vt: Int = 0
            )
        }

        data class PlBean(
                var cnt: Int = 0,
                var pd: List<PdBean>? = null
        ) {
            data class PdBean(
                    var c: Int = 0,
                    var cd: Int = 0,
                    var fmt: Int = 0,
                    var fn: String? = null,
                    var h: Int = 0,
                    var r: Int = 0,
                    var url: String? = null,
                    var w: Int = 0
            )
        }
    }
}