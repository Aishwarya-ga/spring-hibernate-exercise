package com.stackroute.form.dao;


import java.util.List;

import com.stackroute.form.model.Track;

public interface TrackDAO {

	public boolean saveTrack(Track track);

	public String getTrackById(int id);

}