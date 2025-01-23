package com.aneesakunju.shuffle_service.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ShuffleService {
    public List<Integer> shuffle(int number) {
        int[] arr = new int[number];
        for (int i = 1; i <= number; i++) {
            arr[i - 1] = i;
        }
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIdx = random.nextInt(arr.length);
            int temp = arr[randomIdx];
            arr[randomIdx] = arr[i];
            arr[i] = temp;
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list;
    }
}
