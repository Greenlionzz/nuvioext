package com.nuvio.extension

import android.content.Intent
import android.net.Uri
import com.battlelancer.seriesguide.api.Action
import com.battlelancer.seriesguide.api.Episode
import com.battlelancer.seriesguide.api.Movie
import com.battlelancer.seriesguide.api.SeriesGuideExtension

class NuvioExtension : SeriesGuideExtension("NuvioExtension") {

    override fun onRequest(episode: Episode) {
        val tmdbId = episode.tmdbId ?: return
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("nuvio://show/$tmdbId")
            setPackage("com.nuvio.app")
        }

        publishAction(
            episode,
            Action.Builder("Open in Nuvio", intent).build()
        )
    }

    override fun onRequest(movie: Movie) {
        val tmdbId = movie.tmdbId ?: return
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("nuvio://movie/$tmdbId")
            setPackage("com.nuvio.app")
        }

        publishAction(
            movie,
            Action.Builder("Open in Nuvio", intent).build()
        )
    }
}
