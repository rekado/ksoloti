/**
 * Copyright (C) 2013, 2014 Johannes Taelman
 * Edited 2023 - 2024 by Ksoloti
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
#ifndef __AXOBOARD_H
#define __AXOBOARD_H

#include "axoloti_defines.h"

/* Total number of channels to be sampled by a single ADC operation.*/
#define ADC_GRP1_NUM_CHANNELS   14

/* Depth of the conversion buffer, channels are sampled four times each.*/
#define ADC_GRP1_BUF_DEPTH      1

/* Total number of additional channels to be sampled via ADC3 currently without DMA.*/
#define ADC_GRP2_NUM_CHANNELS   5

/* Depth of the ADC3 conversion buffer, channels are sampled four times each.*/
#define ADC_GRP2_BUF_DEPTH      1

extern unsigned short adcvalues[ADC_GRP1_NUM_CHANNELS+ADC_GRP2_NUM_CHANNELS];

void axoloti_board_init(void);
void adc_init(void);
// void adc3_init(void);
void adc_configpads(void);
void adc_convert(void);


#define LED1_PORT GPIOG
#define LED1_PIN 6
#define LED2_PORT GPIOC
#define LED2_PIN 6
// SW1 is also BOOT0
#define SW1_PORT GPIOB
#define SW1_PIN 5
#define SW2_PORT GPIOA
#define SW2_PIN 10
#define OCFLAG_PORT GPIOG
#define OCFLAG_PIN 13
#define SPILINK_JUMPER_PORT GPIOD
#define SPILINK_JUMPER_PIN 12

#ifdef HAS_SD_CARD_DETECT
#define SDCSW_PORT GPIOD
#define SDCSW_PIN 13
#endif

#define SDMIDI SD6

#endif
