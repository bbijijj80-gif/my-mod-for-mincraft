#!/usr/bin/env python3
"""Generate 16x16 Minecraft item textures for Grandium mod."""

import math
import os
from PIL import Image, ImageDraw

OUT = os.path.join(
    os.path.dirname(__file__),
    "..",
    "src",
    "main",
    "resources",
    "assets",
    "grandium",
    "textures",
    "items",
)
OUT = os.path.normpath(OUT)
os.makedirs(OUT, exist_ok=True)


def lerp(a, b, t):
    return tuple(int(a[i] + (b[i] - a[i]) * t) for i in range(3))


def save(name, img):
    path = os.path.join(OUT, f"{name}.png")
    img.save(path)
    print(f"Created {path}")


def dust_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    base = (120, 60, 180, 255)
    gold = (255, 210, 80, 255)
    for y in range(16):
        for x in range(16):
            n = (math.sin(x * 0.9) + math.cos(y * 1.1)) * 0.5 + 0.5
            if 3 <= x <= 12 and 3 <= y <= 12:
                if (x + y) % 3 == 0:
                    c = lerp(base, gold, n)
                    img.putpixel((x, y), c + (255,))
                elif (x * y) % 5 == 0:
                    img.putpixel((x, y), (255, 255, 255, 200))
    d.ellipse([5, 5, 10, 10], fill=(200, 150, 255, 255))
    save("primal_dust", img)


def shard_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    points = [(8, 1), (13, 6), (11, 14), (5, 14), (3, 6)]
    d.polygon(points, fill=(40, 10, 80, 255), outline=(180, 120, 255, 255))
    d.polygon([(8, 4), (10, 8), (8, 12), (6, 8)], fill=(120, 220, 255, 220))
    d.line([(8, 2), (8, 13)], fill=(255, 255, 255, 180), width=1)
    save("void_shard", img)


def ingot_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    d.rectangle([3, 5, 12, 10], fill=(255, 200, 50, 255), outline=(180, 120, 20, 255))
    d.rectangle([4, 6, 11, 9], fill=(255, 230, 120, 255))
    for x in range(4, 12):
        img.putpixel((x, 6), (255, 255, 200, 255))
    d.line([(3, 5), (12, 5)], fill=(255, 255, 180, 255))
    save("grandium_ingot", img)


def core_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    d.ellipse([2, 2, 13, 13], fill=(60, 0, 100, 255), outline=(255, 180, 0, 255))
    d.ellipse([5, 5, 10, 10], fill=(255, 100, 255, 255))
    d.ellipse([7, 7, 8, 8], fill=(255, 255, 255, 255))
    for angle in range(0, 360, 45):
        rad = math.radians(angle)
        x1 = 8 + int(math.cos(rad) * 2)
        y1 = 8 + int(math.sin(rad) * 2)
        x2 = 8 + int(math.cos(rad) * 6)
        y2 = 8 + int(math.sin(rad) * 6)
        d.line([(x1, y1), (x2, y2)], fill=(255, 220, 100, 200), width=1)
    save("grandium_core", img)


def blade_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    # blade
    d.polygon([(7, 0), (9, 0), (9, 10), (7, 10)], fill=(220, 230, 255, 255))
    d.polygon([(7, 0), (8, 0), (8, 10), (7, 10)], fill=(255, 255, 255, 255))
    d.polygon([(7, 1), (9, 1), (8, 9)], fill=(180, 200, 255, 255))
    # golden guard
    d.rectangle([4, 10, 11, 11], fill=(255, 200, 40, 255))
    d.rectangle([3, 11, 12, 12], fill=(255, 170, 20, 255))
    # handle
    d.rectangle([7, 12, 8, 15], fill=(80, 40, 10, 255))
    # pommel
    d.rectangle([6, 15, 9, 15], fill=(255, 200, 40, 255))
    # glow edge
    d.line([(7, 1), (7, 9)], fill=(255, 255, 255, 255))
    save("annihilator_blade", img)


def summoner_texture():
    img = Image.new("RGBA", (16, 16), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    # Dark void orb base
    d.ellipse([2, 2, 13, 13], fill=(20, 5, 40, 255), outline=(80, 20, 100, 255))
    # Swirling void energy
    for i in range(8):
        angle = math.radians(i * 45)
        x1 = 8 + int(math.cos(angle) * 3)
        y1 = 8 + int(math.sin(angle) * 3)
        x2 = 8 + int(math.cos(angle) * 5)
        y2 = 8 + int(math.sin(angle) * 5)
        d.line([(x1, y1), (x2, y2)], fill=(150, 50, 200, 180), width=1)
    # Glowing core
    d.ellipse([5, 5, 10, 10], fill=(100, 20, 150, 255))
    d.ellipse([6, 6, 9, 9], fill=(180, 80, 220, 255))
    d.ellipse([7, 7, 8, 8], fill=(255, 200, 255, 255))
    # Void sparks
    img.putpixel((3, 8), (200, 100, 255, 255))
    img.putpixel((12, 8), (200, 100, 255, 255))
    img.putpixel((8, 3), (200, 100, 255, 255))
    img.putpixel((8, 12), (200, 100, 255, 255))
    save("reaper_summoner", img)


if __name__ == "__main__":
    dust_texture()
    shard_texture()
    ingot_texture()
    core_texture()
    blade_texture()
    summoner_texture()
    print("All textures generated.")
