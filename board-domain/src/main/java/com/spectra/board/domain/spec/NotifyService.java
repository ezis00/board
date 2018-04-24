package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Notify;

public interface NotifyService
{
    String register(Notify notify);

    Notify find(String notifyId);
}
