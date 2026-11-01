#!/usr/bin/env bash
# =============================================================================
# publish-wiki.sh
# Script per publicar els fitxers de la carpeta wiki/ al GitHub Wiki
#
# Ús:
#   chmod +x wiki/publish-wiki.sh
#   ./wiki/publish-wiki.sh https://github.com/USUARI/DAMPJ6-Android.git
# =============================================================================

set -e

REPO_URL="${1}"

if [ -z "$REPO_URL" ]; then
  echo "❌ Cal especificar la URL del repositori."
  echo "   Ús: ./wiki/publish-wiki.sh https://github.com/USUARI/DAMPJ6-Android.git"
  exit 1
fi

WIKI_URL="${REPO_URL%.git}.wiki.git"

echo "📖 Publicant wiki a: $WIKI_URL"
echo ""

TMPDIR=$(mktemp -d)
WIKI_DIR="$(dirname "$0")"

echo "📥 Clonant el repositori wiki..."
git clone "$WIKI_URL" "$TMPDIR" 2>/dev/null || {
  echo "⚠️  No s'ha pogut clonar. Inicialitzant repositori wiki buit..."
  git init "$TMPDIR"
  cd "$TMPDIR"
  git remote add origin "$WIKI_URL"
  cd - > /dev/null
}

echo "📋 Copiant fitxers de la wiki..."
cp "$WIKI_DIR"/*.md "$TMPDIR/"

cd "$TMPDIR"
git add -A
git commit -m "docs: actualitzar wiki del projecte DAMPJ6-Android

- Home: índex complet amb tots els mòduls M01-M44
- M01-M44: documentació detallada de cada exercici
- Actualitzat per a Java 25 i API 36 (Android 16)"

echo "📤 Pujant la wiki a GitHub..."
git push -u origin master 2>/dev/null || git push -u origin main

echo ""
echo "✅ Wiki publicada correctament!"
echo "   Accedeix a: ${REPO_URL%.git}/wiki"

cd - > /dev/null
rm -rf "$TMPDIR"
